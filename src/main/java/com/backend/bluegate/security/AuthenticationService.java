package com.backend.bluegate.security;

import com.backend.bluegate.exception.AuthenticationException;
import com.backend.bluegate.model.User;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    User register(String email, String username, String password);

    User login(String login, String password) throws AuthenticationException;

    User getAuthenticated(Authentication auth);
}
