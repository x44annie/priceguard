package com.data.priceguard.service;

import com.data.priceguard.dto.request.UserLoginRequest;
import com.data.priceguard.dto.request.UserRegisterRequest;
import com.data.priceguard.dto.response.AuthResponse;
import com.data.priceguard.dto.response.UserResponse;
import com.data.priceguard.entity.User;
import com.data.priceguard.exception.EmailAlreadyExistsException;
import com.data.priceguard.exception.UserNotFoundException;
import com.data.priceguard.exception.WrongPasswordException;
import com.data.priceguard.mapper.UserMapper;
import com.data.priceguard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    @Transactional
    public UserResponse register(UserRegisterRequest dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistsException(dto.email());
        }
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        User saved = userRepository.save(user);

        return userMapper.toResponse(saved);
    }

    public AuthResponse login(UserLoginRequest dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserNotFoundException(dto.email()));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new WrongPasswordException();
        }

        String token = jwtService.generateToken(user.getUid());
        return new AuthResponse(token);
    }
}
