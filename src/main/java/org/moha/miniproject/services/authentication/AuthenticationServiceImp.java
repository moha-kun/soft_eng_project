package org.moha.miniproject.services.authentication;

import org.moha.miniproject.Repositories.UserRepository;
import org.moha.miniproject.dto.AuthenticationRequest;
import org.moha.miniproject.dto.AuthenticationResponse;
import org.moha.miniproject.services.jwt.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private JWTService jwtService;
        @Autowired
        private AuthenticationManager authenticationManager;

        @Override
        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new RuntimeException("User with email " + request.getEmail() + " not found"));

                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword(),
                                                user.getAuthorities()));

                var token = jwtService.generateToken(user);

                return AuthenticationResponse.builder()
                                .token(token)
                                .build();
        }

}
