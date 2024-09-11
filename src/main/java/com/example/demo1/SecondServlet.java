package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second-servlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to Second Servlet</h1>");
        out.println("<p>This is a demonstration of the GET method.</p>");
        out.println("<form action='second-servlet' method='post'>");
        out.println("<input type='submit' value='Send POST Request'/>");
        out.println("</form>");
        out.println("<br/><a href='index.jsp'>Back to Home</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Second Servlet POST Method</h1>");
        out.println("<p>POST request received!</p>");
        out.println("<br/><a href='second-servlet'>Back to GET Method</a>");
        out.println("</body></html>");
    }
}
