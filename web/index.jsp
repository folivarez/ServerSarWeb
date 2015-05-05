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
            out.println("<h3> Lanzo socket </h3>");

            if (!a_victima.isEmpty()) {
                Victima victima = new Victima(a_victima);

                out.println("<h3> edad " + victima.getS_edad() + "</h3>");
                out.println("<h3> ojos " + victima.getS_ojos() + "</h3>");
                System.out.println("estoy aca");
            }


        %>

    </body>
</html>
