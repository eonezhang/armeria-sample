package me.eone.fakemall.common;

import com.linecorp.armeria.common.logging.RequestLog;
import com.linecorp.armeria.common.logging.RequestOnlyLog;
import com.linecorp.armeria.common.metric.MeterIdPrefix;
import com.linecorp.armeria.common.metric.MeterIdPrefixFunction;

import io.micrometer.core.instrument.MeterRegistry;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/20-2:55 PM
 */
public class MeterIdPrefixFunctionImpl implements MeterIdPrefixFunction {

    private final String name;
    private final String serviceName;

    public MeterIdPrefixFunctionImpl(String name, String serviceName) {
        this.name = name;
        this.serviceName = serviceName;
    }

    @Override
    public MeterIdPrefix completeRequestPrefix(MeterRegistry registry, RequestLog log) {
        return MeterIdPrefixFunction.ofDefault(name)
                                    .withTags("handler", serviceName)
                                    .completeRequestPrefix(registry, log);
    }

    @Override
    public MeterIdPrefix activeRequestPrefix(MeterRegistry registry, RequestOnlyLog log) {
        return MeterIdPrefixFunction.ofDefault(name)
                                    .withTags("handler", serviceName)
                                    .activeRequestPrefix(registry, log);
    }
}
