package com.boshima.web.converter;

import com.boshima.core.model.BaseEntity;
import com.boshima.web.dto.BaseDto;

/**
 * Created by paul on 5/1/2017.
 */
public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}
