package ru.kata.spring.boot_security.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
    private String roleNames;
}
