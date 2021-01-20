package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import org.homeapart.repository.UserRepository;
import org.homeapart.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



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
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);

    }

    @Override
    public Long delete(Long userId) {
        return userRepository.deleteUserById(userId);
    }

    @Override
    public List<Role> findRole(Long id){return userRepository.findRole(id);}
}
