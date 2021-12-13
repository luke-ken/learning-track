package com.sideproject.learningtrack.service.user;

import com.sideproject.learningtrack.domain.user.Role;
import com.sideproject.learningtrack.domain.user.User;
import com.sideproject.learningtrack.repository.UserRepository;
import com.sideproject.learningtrack.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenService.createToken(authentication);
    }

    public void signup(String username, String password, Set<Role> role) {
        if(!userRepository.existsByUsername(username)) {
            User user = new User(username, passwordEncoder.encode(password), role);
            userRepository.insert(user);
        }
    }
}
