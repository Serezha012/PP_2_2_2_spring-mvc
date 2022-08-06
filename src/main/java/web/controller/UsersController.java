package web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.naming.Binding;
import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserList(Model model) {
        model.addAttribute("getUserList", userService.getUserList());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("getUserById", userService.getUserById(id));
        return "users/user";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "users/new";
    }


    @PostMapping()
    public String createUser(@ModelAttribute("newUser") User user) {


        userService.save(user);
        return "redirect:/users";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";

    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {

        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String deleteAllUsers(){
        userService.deleteAll();
        return "redirect:/users";
    }

}
