package com.ping.sample.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RefreshTokenSendRedirect extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)

            throws ServletException, IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        //res.sendRedirect("../../.well-known/openid-configuration");
        res.sendRedirect("/RefreshTokenServlet");

        System.out.println("RefreshTokenSendRedirect");

        out.close();
    }

}
