package develoPK.developk.controller;

import develoPK.developk.domain.User;
import develoPK.developk.repository.UserRepository;
import develoPK.developk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/save")
    public void userSave(@RequestBody User user){
        userService.join(user);
    }
}
