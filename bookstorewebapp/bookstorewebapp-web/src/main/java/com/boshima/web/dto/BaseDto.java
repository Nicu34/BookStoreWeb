package com.boshima.web.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by paul on 5/1/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BaseDto implements Serializable {
    private Long id;
}
