package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.error.UserNotFoundException;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.model.UserInDto;
import ru.kata.spring.boot_security.demo.model.UserOutDto;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserOutDto> getAll(int pageNumber, int pageSize) {
        Page<User> all = userRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return userMapper.toDto(all);
    }

    @Transactional(readOnly = true)
    @Override
    public UserOutDto getByEmail(String email) {
        return userMapper.toDto(getByEmailOrThrowException(email));
    }

    @Transactional(readOnly = true)
    @Override
    public Long getTotalCount() {
        return userRepository.count();
    }

    @Transactional
    @Override
    public UserOutDto create(UserInDto user) {
        return userMapper.toDto(userRepository.save(userMapper.toUser(user)));
    }

    @Transactional
    @Override
    public UserOutDto update(long id, UserInDto userDto) {
        User user = getByIdOrThrowException(id);
        userMapper.updateUserFromDto(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.delete(getByIdOrThrowException(id));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return getByEmailOrThrowException(email);
    }

    private User getByIdOrThrowException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("user with id=%d not found", id)));
    }

    private User getByEmailOrThrowException(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user with email=%s not found", email)));
    }
}
