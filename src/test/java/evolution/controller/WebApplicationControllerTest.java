package evolution.controller;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class WebApplicationControllerTest {
    @Test
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8080/request", Void.class);
    }
}
