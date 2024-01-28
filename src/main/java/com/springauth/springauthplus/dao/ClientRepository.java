package com.springauth.springauthplus.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springauth.springauthplus.entity.Client;


/**
 * Client repository
 * 
 * @author Brian Long
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    
    Optional<Client> findByClientId(String clientId);
}
