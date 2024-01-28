package com.springauth.springauthplus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springauth.springauthplus.entity.AuthorizationConsent;
import java.util.Optional;

/**
 * AuthorizationConsent Repository
 * 
 * @author Brian Long
 */
public interface AuthorizationConsentRepository
        extends JpaRepository<AuthorizationConsent, AuthorizationConsent.AuthorizationConsentId> {

    Optional<AuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId,
            String principalName);

    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
