package com.boshima.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.boshima.core.model.Client;
import com.boshima.web.dto.ClientDto;

/**
 * Created by paul on 5/2/2017.
 */

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {
    private static final Logger log = LoggerFactory.getLogger(ClientConverter.class);

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto clientDto = new ClientDto(client.getName());
        clientDto.setId(client.getId());
        return clientDto;
    }
}
