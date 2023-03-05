package evolution.controller;

import com.alibaba.fastjson.JSONObject;
import evolution.controller.data.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class WebApplicationServlet extends HttpServlet {
    /**
     * TODO: Write the reflection codings in here.
     */

    /**
     *
     * init
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("hello world");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // path
        String uri = request.getRequestURI();
        System.out.println(uri);
        // Replace "/servler" with "".

        // html
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<p>Hello World!</p>");
//        out.flush();

        // json
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        User user = new User();
//        user.name = "Peter"; user.age = 10;
//        String jsonString = JSONObject.toJSONString(user);
//        out.print(jsonString);
//        out.flush();
    }

    /**
     * TODO: Write the reflection codings in here.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World!</p>");
        // json
    }
}
