package com.boshima.core.service;

import com.boshima.core.model.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nicu on 30/04/2017.
 */
public interface ClientService {

    Client findOne(Long id);

    List<Client> findAll();

    Client updateClient(Long clientId, String Name);

    Client createClient( String Name);

    void deleteClient(Long clientId);

}
