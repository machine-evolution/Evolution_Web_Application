package evolution.controller;

import evolution.controller.data.User;
import evolution.service.WebApplicationService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebApplicationController {
    public List<User> users;

    @Autowired
    public WebApplicationService service;

    @PostConstruct
    public void postConstruct() {
        this.users = new ArrayList<>();
    }

    /**
     * TODO: Lists all kinds of methods.
     */
    @GetMapping("/request")
    public void request(HttpServletRequest request) {
        // remote host
        String remoteHost = request.getRemoteHost();
        System.out.println("remoteHost: " + remoteHost);
        // remote address
        String remoteAddress = request.getRemoteAddr();
        System.out.println("remoteAddress: " + remoteAddress);
    }

    /**
     * TODO: Lists all kinds of methods.
     */
    @GetMapping("/response")
    public void response(HttpServletResponse response) {
        // status
        response.setStatus(10);
        int status = response.getStatus();
        System.out.println("status: " + status);
    }
}
