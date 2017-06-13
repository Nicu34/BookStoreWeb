package com.boshima.core.repository;

import com.boshima.core.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by nicu on 30/04/2017.
 */
@NoRepositoryBean
@Transactional
public interface BookstoreRepository <T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {
}
