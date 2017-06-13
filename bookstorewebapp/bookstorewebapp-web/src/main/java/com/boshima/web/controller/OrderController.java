package com.boshima.web.controller;

import com.boshima.core.model.Order;
import com.boshima.core.service.BookService;
import com.boshima.core.service.ClientService;
import com.boshima.core.service.OrderService;
import com.boshima.web.converter.BookConverter;
import com.boshima.web.converter.ClientConverter;
import com.boshima.web.converter.OrderConverter;
import com.boshima.web.dto.ClientsDto;
import com.boshima.web.dto.EmptyJsonResponse;
import com.boshima.web.dto.OrderDto;
import com.boshima.web.dto.OrdersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by nicu on 15/05/2017.
 */
@RestController
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    protected ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @Autowired
    protected BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    @Autowired
    protected OrderService orderService;

    @Autowired
    private OrderConverter orderConverter;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public OrdersDto getOrders() {
        log.trace("getOrders");

        List<Order> orders = orderService.findAll();

        log.trace("getOrders: orders={}", orders);

        return new OrdersDto(orderConverter.convertModelsToDtos(orders));
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.PUT)
    public OrderDto updateOrder(
            @PathVariable final Long orderId,
            @RequestBody final Map<String, String> data) {
        log.trace("updateOrder: orderId={}, data={}", orderId, data);

        Order order = orderService.updateOrder(orderId,
                clientService.findOne(Long.parseLong(data.get("clientId").toString())),
                bookService.findOne(Long.parseLong(data.get("bookId").toString())));

        OrderDto result = orderConverter.convertModelToDto(order);

        log.trace("updateOrder: result={}", result);

        return result;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public OrderDto createOrder(
            @RequestBody final Map<String, String> data) {
        log.trace("createOrder: orderDto={}", data);

        Order order = orderService.createOrder(bookService.findOne(Long.parseLong(data.get("bookId").toString())),
                clientService.findOne(Long.parseLong(data.get("clientId").toString())));

        OrderDto result = orderConverter.convertModelToDto(order);

        log.trace("createOrder: result={}", result);

        return result;
    }

    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClient(@PathVariable final Long orderId) {
        log.trace("deleteOrder: orderId={}", orderId);

        orderService.deleteOrder(orderId);

        log.trace("deleteOrder - method end");

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }

}
