package evolution.controller;

import evolution.controller.data.GetResponse;
import evolution.controller.data.PostRequest;
import evolution.controller.data.PostResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WebApplicationController {
    @GetMapping("/get")
    public GetResponse get() {
        GetResponse response = new GetResponse();
        response.message = "This is a GET method.";
        return response;
    }

    @GetMapping("/getByPathVariable/{name}")
    public GetResponse getByPathVariable(@PathVariable("name") String name) {
        GetResponse response = new GetResponse();
        response.message = "The name received is " + name + ".";
        return response;
    }

    @GetMapping("/getByRequestParameter")
    public GetResponse getByRequestParameter(@RequestParam("name") String name,
                                             @RequestParam("age") int age) {
        GetResponse response = new GetResponse();
        response.message = "The person " + name + " is " + age + " years old.";
        return response;
    }

    @PostMapping("/post")
    public PostResponse post(@RequestBody PostRequest request) {
        PostResponse response = new PostResponse();
        response.message = "[" + request.name + ", " + request.gender + ", " +  request.age + "]";
        return response;
    }

    @PostMapping("/postByRequestParameter")
    public PostResponse postByRequestParameter(@RequestBody PostRequest request,
                                               @RequestParam("gender") String gender) {
        PostResponse response = new PostResponse();
        response.message = "The person's name is: " + Optional.ofNullable(request.name).orElse("unknown")
        + " and the person is a " + gender + ".";
        return response;
    }

    @PutMapping("/put")
    public void put() {
        System.out.println("This is a PUT method.");
    }

    @DeleteMapping("/delete")
    public void delete() {
        System.out.println("This is a DELETE method.");
    }
}
