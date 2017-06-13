package com.boshima.core.repository;

import com.boshima.core.model.Client;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nicu on 30/04/2017.
 */
public interface ClientRepository extends BookstoreRepository<Client, Long> {
}
