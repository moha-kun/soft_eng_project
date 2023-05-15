package org.moha.miniproject.services.authentication;

import org.moha.miniproject.dto.AuthenticationRequest;
import org.moha.miniproject.dto.AuthenticationResponse;
import org.moha.miniproject.dto.RegisterRequest;

public interface AuthenticationService {

  AuthenticationResponse authenticate(AuthenticationRequest request);
}
