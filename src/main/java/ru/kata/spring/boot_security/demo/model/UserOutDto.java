package ru.kata.spring.boot_security.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserOutDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String roles;
}
