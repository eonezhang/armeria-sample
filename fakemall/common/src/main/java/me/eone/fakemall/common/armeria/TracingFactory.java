package me.eone.fakemall.common.armeria;

import java.io.IOException;
import java.util.logging.Logger;

import com.linecorp.armeria.common.brave.RequestContextCurrentTraceContext;

import brave.Tracing;
import brave.handler.SpanHandler;
import brave.http.HttpTracing;
import brave.propagation.CurrentTraceContext;
import brave.propagation.StrictScopeDecorator;
import brave.sampler.Sampler;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.brave.AsyncZipkinSpanHandler;
import zipkin2.reporter.urlconnection.URLConnectionSender;

import static java.util.Objects.isNull;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/23-11:33 AM
 */
public final class TracingFactory {
    private static Tracing tracing;
    private static HttpTracing httpTracing;

    /** Controls aspects of tracing such as the name that shows up in the UI */
    public static synchronized Tracing create(String serviceName) {
        if (isNull(tracing)) {
            SpanHandler zipkinSpanHandler = AsyncZipkinSpanHandler.newBuilder(spanReporter(sender()))
                                                                  .build();

            final CurrentTraceContext currentTraceContext =
                  RequestContextCurrentTraceContext.builder()
                                                   .nonRequestThread("nonrequest-")
                                                   .addScopeDecorator(StrictScopeDecorator.create())
                                                   .build();
            tracing = Tracing.newBuilder()
                             .localServiceName(serviceName)
                             .currentTraceContext(currentTraceContext)
                             .addSpanHandler(zipkinSpanHandler)
                             .sampler(Sampler.ALWAYS_SAMPLE)
                             .build();
        }
        return tracing;
    }

    /** Configuration for how to send spans to Zipkin */
    public static Sender sender() {
        return URLConnectionSender.create("http://localhost:9411/api/v2/spans");
    }

    /** Configuration for how to buffer spans into messages for Zipkin */
    public static AsyncReporter<Span> spanReporter(Sender sender) {
        final AsyncReporter<Span> spanReporter = AsyncReporter.create(sender);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            spanReporter.close(); // Make sure spans are reported on shutdown
            try {
                sender.close(); // Release any network resources used to send spans
            } catch (IOException e) {
                Logger.getAnonymousLogger().warning("error closing trace sender: " + e.getMessage());
            }
        }));

        return spanReporter;
    }

    public static synchronized HttpTracing httpTracing(Tracing tracing) {
        if (isNull(httpTracing)) {
//            httpTracing = HttpTracing.newBuilder(tracing)
//                       .clientRequestParser(ArmeriaHttpClientParser.get())
//                       .clientResponseParser(ArmeriaHttpClientParser.get())
//                       .build();
            httpTracing = HttpTracing.create(tracing);
        }
        return httpTracing;
    }
}
