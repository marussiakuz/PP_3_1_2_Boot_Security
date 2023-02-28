package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.UserInDto;
import ru.kata.spring.boot_security.demo.model.UserOutDto;

import java.util.List;

public interface UserService {

    List<UserOutDto> getAll(int pageNumber, int pageSize);

    Long getTotalCount();

    UserOutDto create(UserInDto user);

    UserOutDto update(long id, UserInDto user);

    UserOutDto getByEmail(String email);

    void delete(long id);
}
