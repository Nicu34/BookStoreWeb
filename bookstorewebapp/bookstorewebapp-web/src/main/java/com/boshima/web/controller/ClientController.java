package com.boshima.web.controller;

import com.boshima.core.model.Client;
import com.boshima.core.service.ClientService;
import com.boshima.web.converter.ClientConverter;
import com.boshima.web.dto.ClientDto;
import com.boshima.web.dto.ClientsDto;
import com.boshima.web.dto.EmptyJsonResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nicu on 30/04/2017.
 */
@RestController
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    protected ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;


    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ClientsDto getClients() {
        log.trace("getClients");

        List<Client> clients = clientService.findAll();

        log.trace("getClients: clients={}", clients);

        return new ClientsDto(clientConverter.convertModelsToDtos(clients));
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.PUT)
    public ClientDto updateClient(
            @PathVariable final Long clientId,
            @RequestBody final ClientDto clientDto) {
        log.trace("updateClient: clientId={}, clientDto={}", clientId, clientDto);

        Client client = clientService.updateClient(clientId, clientDto.getName());

        ClientDto result = clientConverter.convertModelToDto(client);

        log.trace("updateClient: result={}", result);

        return result;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ClientDto createClient(
            @RequestBody final ClientDto clientDto) {
        log.trace("createClient: clientDto={}", clientDto);

        Client client = clientService.createClient(clientDto.getName());

        ClientDto result = clientConverter.convertModelToDto(client);

        log.trace("updateClient: result={}", result);

        return result;
    }

    @RequestMapping(value = "clients/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClient(@PathVariable final Long clientId) {
        log.trace("deleteClient: clientId={}", clientId);

        clientService.deleteClient(clientId);

        log.trace("deleteClient - method end");

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }

}
