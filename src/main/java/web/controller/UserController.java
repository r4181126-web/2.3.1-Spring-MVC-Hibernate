package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Users;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("surName") String surName,
                          @RequestParam("department") String department,
                          @RequestParam("salary") int salary,
                          @RequestParam("password") String password) {
        userService.saveUser(name, surName, department, salary, password);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") long id,
                             @RequestParam("name") String name,
                             @RequestParam("surName") String surName,
                             @RequestParam("department") String department,
                             @RequestParam("salary") int salary,
                             @RequestParam("password") String password) {
        userService.updateUser(id, name, surName, department, salary, password);
        return "redirect:/users";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "user-create";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        Users user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
}
