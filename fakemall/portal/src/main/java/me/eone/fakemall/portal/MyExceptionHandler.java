package me.eone.fakemall.portal;

import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.ExceptionHandlerFunction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-9:25 PM
 */
@Slf4j
public class MyExceptionHandler implements ExceptionHandlerFunction {
    @Override
    public HttpResponse handleException(ServiceRequestContext ctx, HttpRequest req, Throwable cause) {
        log.error("error", cause);
        return HttpResponse.of("Error");
    }
}
