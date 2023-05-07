package org.moha.miniproject.services.authentication;

import org.moha.miniproject.Repositories.UserRepository;
import org.moha.miniproject.dto.AuthenticationRequest;
import org.moha.miniproject.dto.AuthenticationResponse;
import org.moha.miniproject.dto.RegisterRequest;
import org.moha.miniproject.services.jwt.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private JWTService jwtService;
        @Autowired
        private AuthenticationManager authenticationManager;

        // TODO re-implement the method since you made User class abstract
        @Override
        public AuthenticationResponse register(RegisterRequest request) {
                /*
                 * var user = User.builder()
                 * .firstName(request.getFirstName())
                 * .lastName(request.getLastName())
                 * .email(request.getEmail())
                 * .password(passwordEncoder.encode(request.getPassword()))
                 * .role(request.getRole().equals("manager") ? Role.ROLE_MANAGER :
                 * Role.ROLE_CONDUCTOR)
                 * .build();
                 * userRepository.save(user);
                 * var token = jwtService.generateToken(user);
                 * return AuthenticationResponse.builder()
                 * .token(token)
                 * .build();
                 */
                return null;
        }

        @Override
        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new RuntimeException("User not found"));

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
