package com.myexample.security.auth;

import com.myexample.security.config.JwtService;
import com.myexample.security.user.Role;
import com.myexample.security.user.User;
import com.myexample.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  public AuthenticationResponse register(RegisterRequest request) {
    var user =
        User.builder()
            .firstname(request.getFirstName())
            .lastname(request.getLastName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    return null;
  }
}
