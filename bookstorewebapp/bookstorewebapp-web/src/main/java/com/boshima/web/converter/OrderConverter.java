package com.boshima.web.converter;

import com.boshima.core.model.Order;
import com.boshima.web.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Component;

/**
 * Created by nicu on 15/05/2017.
 */
@Component
public class OrderConverter extends BaseConverter<Order,OrderDto> {
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private ClientConverter clientConverter;
    @Override
    public OrderDto convertModelToDto(Order order) {
        OrderDto orderDto = new OrderDto(
                bookConverter.convertModelToDto(order.getBook()),
                clientConverter.convertModelToDto(order.getClient()));
        orderDto.setId(order.getId());
        return orderDto;
    }
}
