package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.homeapart.domain.User;
import org.homeapart.repository.impl.UserRepositoryImpl;
import org.homeapart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepositoryImpl userRepository;

    @Override
    public Long delete(User user) {
        return userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional <User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
