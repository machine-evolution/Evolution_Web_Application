package evolution;

import evolution.controller.data.EchoRequest;
import evolution.controller.data.EchoResponse;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class ControllerTest {
    @Test
    public void testEcho() {
        RestTemplate restTemplate = new RestTemplate();
        EchoRequest request = new EchoRequest();
        request.message = "你瞅啥";
        System.out.println("request message: " + request.message);
        EchoResponse response = restTemplate.postForObject("http://localhost:8080/echo", request, EchoResponse.class);
        System.out.println("response message: " + response.message);
    }
}
