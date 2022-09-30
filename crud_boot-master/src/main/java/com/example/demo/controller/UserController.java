package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("index", userService.getUsers());
        System.out.println(userService.getUsers());
        return "index";
    }

    @GetMapping("/add")
    public String getUser() {
        return "/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("addUser") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("edit", userService.getUserById(id));
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("edit") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/";
    }
}
