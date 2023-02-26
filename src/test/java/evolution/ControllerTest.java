package evolution;

import evolution.week1.controller.data.EchoRequest;
import evolution.week1.controller.data.EchoResponse;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class ControllerTest {
    @Test
    public void testEcho() {
        RestTemplate restTemplate = new RestTemplate();
        EchoRequest request = new EchoRequest();
        // A polite conversation.
        request.message = "你瞅啥";
        System.out.println("request message: " + request.message);
        EchoResponse response = restTemplate.postForObject("http://localhost:8080/echo", request, EchoResponse.class);
        System.out.println("response message: " + response.message);
        // Another polite conversation.
        request.message = "再瞅一个试试";
        System.out.println("request message: " + request.message);
        response = restTemplate.postForObject("http://localhost:8080/echo", request, EchoResponse.class);
        System.out.println("response message: " + response.message);
    }
}
