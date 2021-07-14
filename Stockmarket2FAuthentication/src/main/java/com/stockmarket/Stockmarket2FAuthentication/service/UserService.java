package com.stockmarket.Stockmarket2FAuthentication.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import com.stockmarket.Stockmarket2FAuthentication.dto.LocalUser;
import com.stockmarket.Stockmarket2FAuthentication.dto.SignUpRequest;
import com.stockmarket.Stockmarket2FAuthentication.exception.UserAlreadyExistAuthenticationException;
import com.stockmarket.Stockmarket2FAuthentication.model.User;

/**
 * @author Biswajit
 * @since 29/06/21
 */
public interface UserService {

	public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
