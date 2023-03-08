package evolution.service;

import com.alibaba.fastjson.JSONObject;
import evolution.controller.data.MatchingScoreResponse;
import evolution.controller.data.RegisterResponse;
import evolution.controller.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebApplicationService {
    public List<User> users;

    public WebApplicationService() {
        this.users = new ArrayList<>();
    }

    public RegisterResponse register(String jsonString) {
        User user = JSONObject.parseObject(jsonString, User.class);
        String id = user.id;
        if (id == null) {
            return new RegisterResponse(false, "The user ID cannot be null.");
        }
        boolean userIdExists = this.users.parallelStream().anyMatch(existingUser -> id.equals(existingUser.id));
        if (userIdExists) {
            return new RegisterResponse(false, "The user ID " + id + " already exists.");
        }
        this.users.add(user);
        return new RegisterResponse(true, "The user is registered successfully.");
    }

    public MatchingScoreResponse matchingScore(String jsonString) {
        List<User> users = JSONObject.parseArray(jsonString, User.class);
        User userA = users.get(0); User userB = users.get(1);
        // ID score
        int result = 0;
        String userAId = Optional.ofNullable(userA).map(User::getId).orElse("");
        String userBId = Optional.ofNullable(userB).map(User::getId).orElse("");
        if (userAId.equals(userBId)) {
            return new MatchingScoreResponse(result);
        }
        // gender score
        String userAGender = Optional.ofNullable(userA).map(User::getGender).orElse("unknown");
        String userBGender = Optional.ofNullable(userB).map(User::getGender).orElse("unknown");
        if (userAGender.equals(userBGender)) {
            return new MatchingScoreResponse(result);
        }
        // education score
        result += 3 - Math.abs(this.educationScore(userA.education) - this.educationScore(userB.education));
        // age score
        int userAAge = Optional.ofNullable(userA).map(User::getAge).orElse(0);
        int userBAge = Optional.ofNullable(userB).map(User::getAge).orElse(0);
        result -= Math.abs(userAAge - userBAge);
        result = Math.max(result, 0);
        return new MatchingScoreResponse(result);
    }

    public int educationScore(String education) {
        return switch (education) {
            case "bachelor" -> 1;
            case "master" -> 2;
            case "doctor" -> 3;
            default -> 0;
        };
    }
}
