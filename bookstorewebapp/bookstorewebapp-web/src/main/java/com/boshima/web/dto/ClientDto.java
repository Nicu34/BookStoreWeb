package com.boshima.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by paul on 5/2/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto extends BaseDto {
    private String name;

    @Override
    public String toString() {
        return "ClientDto{" +
                ", Name='" + name + '\'' +
                '}';
    }
}
