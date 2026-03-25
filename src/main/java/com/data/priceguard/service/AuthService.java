package com.data.priceguard.service;

import com.data.priceguard.dto.UserLogin;
import com.data.priceguard.dto.UserRegister;
import com.data.priceguard.dto.UserResponse;
import com.data.priceguard.entity.User;
import com.data.priceguard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public UserResponse register(UserRegister dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        User saved = userRepository.save(user);

        return new UserResponse(saved.getUid(), saved.getEmail());

    }

    public UserResponse login(UserLogin dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(dto.password())) {
            throw new RuntimeException("Wrong password");
        }

        return new UserResponse(user.getUid(), user.getEmail());
    }
}
