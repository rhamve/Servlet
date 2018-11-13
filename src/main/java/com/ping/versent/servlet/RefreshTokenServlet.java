package com.ping.versent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@WebServlet("/RefreshTokenServlet")
public class RefreshTokenServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String refreshToken = request.getParameter("refresh_token");
        System.out.println("refreshToken="+refreshToken);

        String grantType = request.getParameter("grant_type");
        System.out.println("grantType="+grantType);

        String baseRefreshTokenURL = "https://localhost:9031/as/token.oauth2?grant_type="; //default value hard-coded 'beijing'
        //should be stored in config file
        System.out.println("baseRefreshTokenURL="+baseRefreshTokenURL);

        String refreshTokenURL = baseRefreshTokenURL+ URLEncoder.encode(grantType, "utf-8");
        System.out.println("refreshTokenURL : "+refreshTokenURL);

        refreshTokenURL = refreshTokenURL+"&refresh_token=";
        System.out.println("refreshTokenURL="+refreshTokenURL);

        try {
            if(refreshToken!=null && refreshToken!="")
                refreshTokenURL = refreshTokenURL+ URLEncoder.encode(refreshToken, "utf-8");
                System.out.println("refreshTokenURL="+refreshTokenURL);

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        StringBuilder strBuf = new StringBuilder();

        HttpURLConnection connection=null;
        BufferedReader reader=null;
        try {
            URL url = new URL(refreshTokenURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP POST Request Failed with Error code : "
                        + connection.getResponseCode());
            }

            //Read the content from the defined connection
            //Using IO Stream with Buffer raise highly the efficiency of IO
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String output = null;
            while ((output = reader.readLine()) != null)
                strBuf.append(output);

        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally
        {
            if(reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null)
            {
                connection.disconnect();
            }
        }

        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("RefreshTokenServlet");
        out.println(strBuf.toString());
        //out.println("<h3>Hello World! RefreshTokenServlet</h3>");*/
    }
}

