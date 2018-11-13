package com.ping.sample.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;




@WebServlet("/RefreshTokenServletGet")
public class RefreshTokenServletGet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pfConnectionURL = "https://localhost:9031/.well-known/openid-configuration"; //default value hard-coded 'beijing'
        //should be stored in config file

        /*try {
            if(cityName!=null && cityName!="")
                refreshTokenURL = baseBaiduUrl+URLEncoder.encode(cityName, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }*/

        StringBuilder strBuf = new StringBuilder();

        HttpURLConnection conn=null;
        BufferedReader reader=null;
 /*       try{
            //Declare the connection to weather api url
            URL pfurl = new URL(pfConnectionURL);
            conn = (HttpURLConnection)pfurl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.setRequestProperty("apikey",apiKey);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + conn.getResponseCode());
            }

            //Read the content from the defined connection
            //Using IO Stream with Buffer raise highly the efficiency of IO
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
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
            if(conn!=null)
            {
                conn.disconnect();
            }
        }
*/
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("RefreshTokenServletGet");
        out.println(strBuf.toString());
        out.println("<h3>Hello World! RefreshTokenServletGet </h3>");
    }
}
