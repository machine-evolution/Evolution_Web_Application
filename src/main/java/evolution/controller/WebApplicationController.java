package evolution.controller;

import evolution.controller.data.CheckIdResponse;
import evolution.controller.data.RegisterRequest;
import evolution.controller.data.RegisterResponse;
import evolution.controller.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebApplicationController {
    public List<User> users;

    public void WebApplicationController() {
        this.users = new ArrayList<>();
    }

    @GetMapping("/checkId")
    public CheckIdResponse checkId(@RequestParam("id") String id) {
        CheckIdResponse response = new CheckIdResponse();
        // TODO: 对users成员变量进行遍历，判断ID是否有重复；若有重复则把valid字段设为false，若无重复则把valid字段设为true；message字段也要相应的进行更改，从而给用户一个清楚的提示
        response.valid = true;
        response.message = "";
        return response;
    }

    @PostMapping("/register")
    public RegisterResponse post(@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        User user = new User();
        user.id = request.id; user.password = request.password;
        user.name = request.name; user.gender = request.gender;
        // TODO: user.age = 从request中获取年龄(age) user.education = 从request中获取学历(education)
        this.users.add(user);
        response.message = "The user is registered successfully.";
        return response;
    }
}
