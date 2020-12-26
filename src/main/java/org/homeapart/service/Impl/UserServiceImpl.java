package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.homeapart.domain.User;
import org.homeapart.repository.UserRepository;
import org.homeapart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;



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
        Optional<User> optional= userRepository.findById(userId);
        return optional.orElseGet(optional::orElseThrow);
    }

    @Override
    public User findByLogin(String login) {
        Optional<User>optional= userRepository.findByLogin(login);

        return optional.orElseGet(optional::orElseThrow);
    }

    @Override
    public Long delete(User user) {
        return userRepository.delete(user);
    }
}
