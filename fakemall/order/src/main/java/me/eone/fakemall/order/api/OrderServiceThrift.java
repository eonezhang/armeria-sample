package me.eone.fakemall.order.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import lombok.Data;
import me.eone.fakemall.common.ThriftUtil;
import me.eone.fakemall.order.CreateOrderReq;
import me.eone.fakemall.order.CreateOrderResp;
import me.eone.fakemall.order.GetOrderReq;
import me.eone.fakemall.order.GetOrderResp;
import me.eone.fakemall.order.Order;
import me.eone.fakemall.order.OrderService.AsyncIface;
import me.eone.fakemall.order.manager.OrderManager;
import me.eone.fakemall.order.model.OrderLine;
import me.eone.fakemall.order.types.CreateOrderDto;
import me.eone.fakemall.order.types.CreateOrderResult;
import me.eone.fakemall.order.types.GetOrderDto;
import me.eone.fakemall.order.types.GetOrderResult;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:12 PM
 */
@Data
public class OrderServiceThrift implements AsyncIface {
    OrderManager orderMgr;

    @Override
    public void createOrder(CreateOrderReq req, AsyncMethodCallback<CreateOrderResp> resultHandler) throws TException {
        CreateOrderDto dto = fromReq(req);
        orderMgr.createOrder(dto)
                .subscribe(r -> resultHandler.onComplete(toResp(r)), e -> resultHandler.onError(ThriftUtil.of(e)));
    }

    private CreateOrderDto fromReq(CreateOrderReq req) {
        int userId = req.getUserId();
        List<OrderLine> orderLines = req.getItems().stream().map(item -> new OrderLine(item.productId, item.amount, item.price))
                                        .collect(Collectors.toList());
        return new CreateOrderDto()
              .setUserId(userId)
              .setOrderLines(orderLines);
    }

    private CreateOrderResp toResp(CreateOrderResult result) {
        Order order = new Order().setId(result.getId());
        CreateOrderResp resp = new CreateOrderResp();
        resp.setOrder(order);

        return resp;
    }

    @Override
    public void getOrder(GetOrderReq req, AsyncMethodCallback<GetOrderResp> resultHandler) throws TException {
        orderMgr.getOrder(fromReq(req))
                .subscribe(r -> resultHandler.onComplete(toResp(r)), e -> ThriftUtil.of(e));
    }

    private GetOrderResp toResp(GetOrderResult result) {
        Order order = new Order(result.getOrder().getOrderId());
        List<Order> orders = Arrays.asList(order);
        return new GetOrderResp(orders);
    }

    private GetOrderDto fromReq(GetOrderReq req) {
        return new GetOrderDto()
              .setOrderId(req.orderId);
    }
}
