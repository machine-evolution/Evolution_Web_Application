package evolution.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Service
public class WebApplicationService {
    public Object get(Map<String, String> request) {
        System.out.println("The non-empty get method has been invoked.");
        System.out.println(request);
        return request;
    }

    @GetMapping("/get")
    public Object get() {
        System.out.println("The empty get method has been invoked.");
        return null;
    }
}
