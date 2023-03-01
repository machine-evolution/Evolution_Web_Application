package evolution.controller;

import evolution.controller.data.GetResponse;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class WebApplicationControllerTest {
    @Test
    public void testGet() {
        RestTemplate restTemplate = new RestTemplate();
        GetResponse response = restTemplate.getForObject("http://localhost:8080/get", GetResponse.class);
        System.out.println(response.message);
    }
}
