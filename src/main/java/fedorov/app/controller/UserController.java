package fedorov.app.controller;

import fedorov.app.model.User;
import fedorov.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "ShowUsers";
    }

    @GetMapping("/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
            User user = userService.findUserById(id);
        System.out.println(user.toString());
        System.out.println("model" + model);
        model.addAttribute("user", user);
        return "/edit";
    }

    @GetMapping("/new")
    public String openPageNew(@ModelAttribute ("user") User user){
        return "/create";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:all";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") @Valid User user,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/create";
        userService.save(user);
        return "redirect:user/all";
    }

    @PostMapping("/{id}")
    public String postEdit(@ModelAttribute() @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/edit";
        userService.update(user);
        return "redirect:all";
    }


}
