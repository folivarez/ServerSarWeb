<%-- 
    Document   : index
    Created on : 04/05/2015, 23:17:00
    Author     : fede
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="codigo.lanzarSocket"%>
<%@page import="codigo.Victima"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Server SAR</title>
    </head>
    <body>
        <h1>Server Web Sar!</h1>

        <%
            ArrayList<String> a_victima = new ArrayList<String>();

            lanzarSocket socket = new lanzarSocket();

            a_victima = socket.startSocket();

            if (!a_victima.get(1).equals("")) {
                int i = 0;
                while (a_victima.size() > i) {
                    out.println("<h3> " + a_victima.get(i) + "</h3>");
                    System.out.println("estoy aca");
                    i++;
                }

            }


        %>

    </body>
</html>
