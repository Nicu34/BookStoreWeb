package com.boshima.web.dto;

import lombok.*;

/**
 * Created by nicu on 15/05/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto extends BaseDto {
    protected BookDto book;
    protected ClientDto client;
}
