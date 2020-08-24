package me.eone.fakemall.portal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.armeria.common.HttpHeaders;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.common.ResponseHeaders;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.ResponseConverterFunction;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-9:32 PM
 */
public class MyResponseConverter implements ResponseConverterFunction {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public HttpResponse convertResponse(ServiceRequestContext ctx, ResponseHeaders headers, Object result, HttpHeaders trailers)
          throws Exception {
        return HttpResponse.of(HttpStatus.OK,
                               MediaType.ANY_APPLICATION_TYPE,
                               objectMapper.writeValueAsString(result),
                               trailers);
    }
}
