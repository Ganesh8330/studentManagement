package com.sms.studentManagement.service.Implements;

import com.sms.studentManagement.dto.LoginRequest;
import com.sms.studentManagement.models.Users;
import com.sms.studentManagement.repository.UserRepository;
import com.sms.studentManagement.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImple implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserImple(UserRepository userRepository, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.authManager = authManager;
    }

    @Override
    public Users createUsers(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String verify(LoginRequest request) {

        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        if (authentication.isAuthenticated())
            return "success";

        return "fail";
    }
}
