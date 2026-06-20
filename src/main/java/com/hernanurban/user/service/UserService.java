package com.hernanurban.user.service;

import com.hernanurban.user.dto.UserRequest;
import com.hernanurban.user.exception.UserNotFoundException;
import com.hernanurban.user.model.User;
import com.hernanurban.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public User findById(Long id) {
        log.info("Fetching user id={}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(UserRequest request) {
        log.info("Creating user email={}", request.email());
        User user = User.builder()
                .email(request.email())
                .name(request.name())
                .dateOfBirth(request.dateOfBirth())
                .build();
        return userRepository.save(user);
    }

    public User update(Long id, UserRequest request) {
        log.info("Updating user id={}", id);
        User user = findById(id);
        user.setEmail(request.email());
        user.setName(request.name());
        user.setDateOfBirth(request.dateOfBirth());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        log.info("Deleting user id={}", id);
        userRepository.delete(findById(id));
    }
}
