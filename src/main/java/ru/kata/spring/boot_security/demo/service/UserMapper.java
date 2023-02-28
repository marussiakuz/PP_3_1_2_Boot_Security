package ru.kata.spring.boot_security.demo.service;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.model.UserInDto;
import ru.kata.spring.boot_security.demo.model.UserOutDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    protected RoleService roleService;
    protected BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Mapping(target = "roles",
            expression = "java(roleService.getAllByName(java.util.Arrays.stream(userInDto.getRoleNames().split(\",\"))" +
                    ".collect(java.util.stream.Collectors.toSet())))")
    @Mapping(target = "password",
            expression = "java(passwordEncoder.encode(userInDto.getPassword()))")
    public abstract User toUser(UserInDto userInDto);

    public abstract UserOutDto toDto(User user);

    public abstract List<UserOutDto> toDto(Page<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles",
            expression = "java(roleService.getAllByName(java.util.Arrays.stream(userInDto.getRoleNames().split(\",\"))" +
                    ".collect(java.util.stream.Collectors.toSet())))")
    public abstract void updateUserFromDto(UserInDto userInDto, @MappingTarget User user);

    public static String map(Set<Role> roles) {
        return isNull(roles) ? null : roles.stream()
                .map(Role::getName)
                .map(name -> name.replace("ROLE_", ""))
                .collect(Collectors.joining(" "));
    }
}
