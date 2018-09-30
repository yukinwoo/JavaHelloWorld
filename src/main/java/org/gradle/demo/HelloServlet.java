package org.gradle.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloservlet", urlPatterns = {"hello"}, loadOnStartup = 1) 
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String s = "<h1>Hello, World!</h1>";
        response.getWriter().print(s);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        if( name == null || name.isEmpty() ) name = "world";
        request.setAttribute("user", name);
        request.getRequestDispatcher("response.jsp").forward(request, response); 
        //String s = String.format("<h1>Hello %s!</h1>", name);
        //response.getWriter().print(s);
    }
}