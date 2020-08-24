package me.eone.mall.order.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.armeria.common.HttpData;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;

import io.micrometer.core.instrument.util.JsonUtils;
import me.eone.mall.order.dto.ProductDto;
import me.eone.mall.order.service.OrderService;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-10:11 PM
 */
public class OrderServiceRestApi {
    private OrderService orderService;
    ObjectMapper mapper = new ObjectMapper();

    public OrderServiceRestApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @Get("/order/{id}")
    public HttpResponse createOrder(@Param("id") Integer id) {
        CompletableFuture<ProductDto> order = orderService.createOrder(id);
        CompletionStage<? extends HttpResponse> future = order
              .handle((productDto, ex) -> {
                  if (ex != null) {
                      return HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR);
                  } else {
                      try {
                          return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, mapper.writeValueAsBytes(productDto));
                      } catch (JsonProcessingException e) {
                          return HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR);
                      }
                  }
              });
        return HttpResponse.from(future);
    }
}
