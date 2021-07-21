package crudproject.controllers;


import crudproject.models.User;
import crudproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("users", userService.index());
        return "users/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("user", userService.show(id));
        return "users/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("user", new User());
        return "users/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user")  User user,
                         BindingResult bindingResult, Model model) throws SQLException {
        if(bindingResult.hasErrors()) {
            return "users/new";
        }

        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id) throws SQLException {
        model.addAttribute("user", userService.show(id));
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         BindingResult bindingResult) throws SQLException {
        if(bindingResult.hasErrors()) {
            return "users/edit";
        }

        userService.update(user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        userService.delete(id);
        return "redirect:/users";
    }
}
