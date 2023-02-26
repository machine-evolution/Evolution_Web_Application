package evolution.week2.controller;

import evolution.week2.controller.data.GetResponse;
import evolution.week2.controller.data.PostRequest;
import evolution.week2.controller.data.PostResponse;
import evolution.week2.controller.data.PutRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/week2")
@RestController
public class WebApplicationControllerWeek2 {
    @GetMapping("/get")
    public GetResponse get() {
        GetResponse response = new GetResponse();
        response.message = "Hello World";
        return response;
    }

    @GetMapping("/getByPathVariable/{name}")
    public GetResponse getByPathVariable(@PathVariable("name") String name) {
        GetResponse response = new GetResponse();
        response.message = "The name received is " + name + ".";
        return response;
    }

    @GetMapping("/getByRequestParameter")
    public GetResponse getByRequestParameter(@RequestParam("age") int age) {
        GetResponse response = new GetResponse();
        if (age < 35) {
            response.message = "此人符合公务员报考要求";
        } else {
            response.message = "此人不符合公务员报考要求";
        }
        return response;
    }
    // TODO: What if there are more than one parameters.
    // TODO: How to use postman to send the request.
    // TODO: What if the request is too large, what if it exceeds 2KB, try it by RestTemplate.

    @PostMapping("/post")
    public PostResponse post(@RequestBody PostRequest request) {
        PostResponse response = new PostResponse();
        System.out.println("The person's name is: " + request.name);
        if (request.age != null && request.age < 35 && !"李天一".equals(request.name)) {
            response.eligible = true;
            System.out.println("添加" + request.name + "至报名表");
        } else {
            response.eligible = false;
        }
        // Use Optional to simplify the coding.
        return response;
    }
    // TODO: post with @PathVariable and @RequestParam
    // TODO: What if the request body is very large.

    @PutMapping("/put")
    public void post(@RequestBody PutRequest request) {
        System.out.println("将原名" + request.oldName + "修改为" + request.newName);
    }
    // TODO: What's the difference between put and post.

    @DeleteMapping("/delete/{id}")
    public void post(@PathVariable("id") String id) {
        System.out.println("ID为" + id + "的学生将被删除");
    }
    // TODO: What's the difference between delete and post.
}
