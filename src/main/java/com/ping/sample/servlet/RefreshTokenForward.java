package com.ping.sample.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RefreshTokenForward extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet--------------start");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //String str = request.getParameter("uname");
        //String st = request.getParameter("upass");
        System.out.println("doGet--------------Middle");
        //if (st.equals("javabeat")) {
        RequestDispatcher rd = request.getRequestDispatcher("../../.well-known/openid-configuration");

        rd.forward(request, response);
        response.setContentType("text/html");
        out = response.getWriter();
        System.out.println("RefreshTokenServlet");


        /*//} else {
            out.print("Sorry username and password error!");
            RequestDispatcher rd = request.getRequestDispatcher("/Hello.html");
            rd.include(request, response);
        } */
        System.out.println("doGet--------------end");
    }

}


