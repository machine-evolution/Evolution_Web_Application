package evolution;

import evolution.controller.WebApplicationServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {// 注册过程
        return new ServletRegistrationBean(new WebApplicationServlet(),"/servlet/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}