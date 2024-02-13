package com.backend.bluegate.security.impl;

import com.backend.bluegate.exception.AlreadyExistsException;
import com.backend.bluegate.exception.AuthenticationException;
import com.backend.bluegate.exception.ResourceNotFoundException;
import com.backend.bluegate.model.User;
import com.backend.bluegate.security.AuthenticationService;
import com.backend.bluegate.service.RoleService;
import com.backend.bluegate.service.UserService;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(String email, String username, String password) {
        if (userService.findByEmail(email).isPresent()) {
            throw new AlreadyExistsException("User already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of(roleService.findByRoleName("USER")));
        user.setPortraitId(1L);
        return userService.add(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> userFromDb = userService.findByEmail(email);
        if (userFromDb.isEmpty()
                || !passwordEncoder.matches(password, userFromDb.get().getPassword())) {
            throw new AuthenticationException("Incorrect username or password!");
        }
        return userFromDb.get();
    }

    public User getAuthenticated(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        return userService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Unknown User"));
    }
}
