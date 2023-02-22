package evolution.controller;

import evolution.controller.data.EchoRequest;
import evolution.controller.data.EchoResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebApplicationController {
    @PostMapping("/echo")
    public EchoResponse echo(@RequestBody EchoRequest request) {
        String requestMessage = request.message;
        System.out.println("server: " + requestMessage);
        String responseMessage = requestMessage;
        if ("你瞅啥".equals(requestMessage)) {
            responseMessage = "瞅你咋地";
        } else if ("再瞅一个试试".equals(requestMessage)) {
            responseMessage = "试试就试试";
        }
        System.out.println("server: " + responseMessage);
        EchoResponse response = new EchoResponse();
        response.message = responseMessage;
        return response;
    }
}
