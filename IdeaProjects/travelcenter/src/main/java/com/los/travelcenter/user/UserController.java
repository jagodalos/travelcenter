package com.los.travelcenter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jagod on 15.05.2017.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String saveUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/saveUserForm";
    }

    @PostMapping(value = "/register")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/all")
    @Secured("ROLE_ADMIN")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/allUsers";
    }
}
