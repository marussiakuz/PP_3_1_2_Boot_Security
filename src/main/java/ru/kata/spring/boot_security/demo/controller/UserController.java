package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.UserInDto;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String getListOfUsers(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize, ModelMap model) {
        model.addAttribute("users", userService.getAll(pageNumber, pageSize));
        model.addAttribute("totalCount", userService.getTotalCount());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", pageSize);
        return "users";
    }

    @GetMapping("/user")
    public String getUser(ModelMap model) {
        model.addAttribute("user", userService.getByEmail(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()));
        return "user";
    }

    @PostMapping("/admin/users")
    public String create(@RequestBody UserInDto user, ModelMap model) {
        userService.create(user);
        model.addAttribute("totalCount", userService.getTotalCount());
        return "users";
    }

    @PatchMapping("/admin/users/{id}")
    public String update(@PathVariable long id, @RequestBody UserInDto user, ModelMap model) {
        userService.update(id, user);
        model.addAttribute("totalCount", userService.getTotalCount());
        return "users";
    }

    @DeleteMapping("/admin/users/{id}")
    public String delete(@PathVariable("id") long id, ModelMap model) {
        userService.delete(id);
        model.addAttribute("totalCount", userService.getTotalCount());
        return "users";
    }
}
