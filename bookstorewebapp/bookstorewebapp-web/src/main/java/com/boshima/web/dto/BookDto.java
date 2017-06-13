package com.boshima.web.dto;
import lombok.*;

/**
 * Created by paul on 5/1/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDto extends BaseDto {
    private String title;
    private String author;
    private double price;
}
