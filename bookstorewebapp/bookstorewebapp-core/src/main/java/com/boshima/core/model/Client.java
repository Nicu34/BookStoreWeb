package com.boshima.core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by nicu on 30/04/2017.
 */
@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Client extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
}
