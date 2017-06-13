package com.boshima.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * Created by nicu on 15/05/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {
    protected Set<OrderDto> orders;
}
