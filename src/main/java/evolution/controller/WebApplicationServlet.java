package evolution.controller;

import evolution.service.WebApplicationService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

public class WebApplicationServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("The initialization method has been invoked.");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        System.out.println("The service method has been invoked.");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("The destroy method has been invoked.");// call it multiple times.
    }

    /**
     * 通过 http://localhost:8080/servlet/get 进行调用
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        // Gets the servlet name.
        String servletName = this.getServletName();
        System.out.println("servletName: " + servletName);
        // Gets the servlet information.
        String servletInformation = this.getServletInfo();
        System.out.println("servletInformation: " + servletInformation);
        // Gets the servlet config.
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("servletConfig: " + servletConfig);
        ServletContext servletContext = this.getServletContext();
        System.out.println("servletContext: " + servletContext);
        */

        // Renders the HTML.
        /*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<marquee><input id=\"\"/></marquee>");// marquee h1 input
        out.flush();
        */

        // Renders the JSON.
        /*
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        User user = new User();
        user.name = "Peter"; user.age = 10;
        String jsonString = JSONObject.toJSONString(user);
        out.print(jsonString);
        out.flush();
         */

        // Invokes the service method using reflection.
        String requestUri = request.getRequestURI();
        System.out.println("requestUri: " + requestUri);
        String methodName = requestUri.replace("/servlet/", "");
        WebApplicationService service = new WebApplicationService();
        try {
            System.out.println("methodName: " + methodName);
            Method method = service.getClass().getDeclaredMethod(methodName, Map.class);
            Map<String, String> map = Map.of("name", "Lucy");
            method.invoke(service, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Renders the HTML.
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World!</p>");
    }
}
