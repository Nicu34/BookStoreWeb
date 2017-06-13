package com.boshima.core.service;

import com.boshima.core.model.Book;
import com.boshima.core.model.Client;
import com.boshima.core.model.Order;

import java.util.List;

/**
 * Created by nicu on 15/05/2017.
 */
public interface OrderService {
    List<Order> findAll();

    Order updateOrder(Long clientId, Client client, Book book);

    Order createOrder(Book book, Client client);

    void deleteOrder(Long orderId);
}
