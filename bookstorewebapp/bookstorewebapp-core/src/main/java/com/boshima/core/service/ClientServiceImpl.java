package com.boshima.core.service;

import com.boshima.core.model.Client;
import com.boshima.core.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nicu on 30/04/2017.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    protected ClientRepository clientRepository;

    @Override
    @Transactional
    public Client findOne(Long id) {
        log.trace("findOne");

        Client client = clientRepository.findOne(id);

        log.trace("findAll: client={}", client);

        return client;
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        log.trace("findAll");

        List<Client> clients = clientRepository.findAll();

        log.trace("findAll: clients={}", clients);

        return clients;
    }

    @Override
    @Transactional
    public Client updateClient(Long clientId, String name) {
        log.trace("updateClient: clientId={}, name={}, age={}",
                clientId, name);

        Client client = clientRepository.findOne(clientId);
        client.setName(name);

        log.trace("updateClient: client={}", client);

        return client;
    }

    @Override
    public Client createClient(String name) {
        log.trace("createClient: Name={}", name);

        Client client = new Client(name);
        client = clientRepository.save(client);

        log.trace("createClient: client={}", client);

        return client;
    }

    @Override
    public void deleteClient(Long clientId) {
        log.trace("deleteClient: ClientId={}", clientId);

        clientRepository.delete(clientId);

        log.trace("deleteClient - method end");
    }
}
