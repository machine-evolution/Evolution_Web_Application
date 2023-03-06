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

    @GetMapping("/request/local")
    public void requestLocal(HttpServletRequest request) {
        String localAddress = request.getLocalAddr();
        System.out.println("localAddress: " + localAddress);
        int localPort = request.getLocalPort();
        System.out.println("localPort: " + localPort);
        String localName = request.getLocalName();
        System.out.println("localName: " + localName);
    }

    @GetMapping("/request/remote")
    public void requestRemote(HttpServletRequest request) {
        String remoteAddress = request.getRemoteAddr();
        System.out.println("remoteAddress: " + remoteAddress);
        int remotePort = request.getRemotePort();
        System.out.println("remotePort: " + remotePort);// chrome, edge
    }

    @GetMapping("/request")
    public void request(HttpServletRequest request) {
        // URI
        String requestUri = request.getRequestURI();
        System.out.println("requestUri: " + requestUri);
        // URL
        String requestUrl = request.getRequestURL().toString();
        System.out.println("requestUrl: " + requestUrl);
        // request ID
        String requestId = request.getRequestId();
        System.out.println("requestId: " + requestId);
    }

    @GetMapping("/request/parameter")
    public void requestParameter(HttpServletRequest request) {
        // key : value
        String name = request.getParameter("name");
        System.out.println("name: " + name);
        String age = request.getParameter("age");
        System.out.println("age: " + age);
    }

    @GetMapping("/response/status")
    public void response(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(199);// 200, 404, 500, 502
        int status = response.getStatus();
        System.out.println("status: " + status);
    }
}
