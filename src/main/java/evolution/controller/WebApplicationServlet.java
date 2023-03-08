package evolution.controller;

import com.alibaba.fastjson.JSONObject;
import evolution.service.WebApplicationService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.stream.Collectors;

public class WebApplicationServlet extends HttpServlet {
    public WebApplicationService service;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtains the method name.
        String requestUri = request.getRequestURI();
        System.out.println("Request URI: " + requestUri);
        String methodName = requestUri.replace("/servlet/", "");
        System.out.println("Method Name: " + methodName);
        // Obtains the JSON string request.
        String jsonStringRequest = request.getReader().lines().collect(Collectors.joining());
        // Invokes the method.
        Object result = null;
        try {
            Method method = this.service.getClass().getDeclaredMethod(methodName, String.class);
            result = method.invoke(this.service, jsonStringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.renderJson(result, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUri = request.getRequestURI();
        System.out.println("Request URI: " + requestUri);
        requestUri = requestUri.replace("/servlet/", "");
        String methodName = null; String parameterString = null;
        int questionMarkIndex = requestUri.indexOf("?");
        if (questionMarkIndex >= 0) {
            methodName = requestUri.substring(0, questionMarkIndex);
            parameterString = requestUri.substring(questionMarkIndex + 1);
        } else {
            methodName = requestUri;
        }
        System.out.println("Method Name: " + methodName);
        System.out.println("Parameter String: " + parameterString);
        Object result = null;
        try {
            // TODO: 模仿doPost方法，使得WebApplicationService中的matchingScore方法可以通过反射的方式被调用
            // result = TODO
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.renderJson(result, response);
    }

    public void renderJson(Object result, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(JSONObject.toJSONString(result));
        out.flush();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.service = new WebApplicationService();
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.service.users.clear();
    }
}
