package com.boshima.core.service;

import com.boshima.core.model.Book;
import com.boshima.core.model.Client;
import com.boshima.core.model.Order;
import com.boshima.core.repository.BookRepository;
import com.boshima.core.repository.ClientRepository;
import com.boshima.core.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nicu on 15/05/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected ClientRepository clientRepository;

    @Autowired
    protected BookRepository bookRepository;

    @Override
    @Transactional
    public List<Order> findAll(){
        log.trace("findAll");

        List<Order> orders = orderRepository.findAll();

        log.trace("findAll: orders={}", orders);

        return orders;
    }

    @Override
    @Transactional
    public Order updateOrder(Long orderId, Client client, Book book) {
        log.trace("updateorder: orderId={}, book={}, client={}", orderId, book, client);

        Order order = orderRepository.findOne(orderId);
        order.setClient(client);
        order.setBook(book);
        orderRepository.save(order);

        log.trace("updateOrder: book={}", order);

        return order;
    }

    @Override
    @Transactional
    public Order createOrder(Book book, Client client) {
        log.trace("createOrder: book={}, client={}", book, client);

        Order order = new Order(client, book);
        order = orderRepository.save(order);

        log.trace("createBook: book={}", order);

        return order;
    }

    @Override
    @Transactional
    public void deleteOrder(Long orderId) {
        log.trace("deleteBook: bookId={}", orderId);

        orderRepository.delete(orderId);

        log.trace("deleteBook - method end");
    }
}
