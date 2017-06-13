package com.boshima.web.dto;

import com.boshima.core.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * Created by nicu on 30/04/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientsDto {
    private Set<ClientDto> clients;
}
