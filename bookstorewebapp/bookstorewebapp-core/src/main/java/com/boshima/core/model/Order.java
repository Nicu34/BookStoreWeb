package com.boshima.core.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by nicu on 15/05/2017.
 */
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order extends BaseEntity<Long> {
    @ManyToOne(optional=false)
    @JoinColumn(name="clientId")
    private Client client;

    @ManyToOne(optional=false)
    @JoinColumn(name="bookId")
    private Book book;
}
