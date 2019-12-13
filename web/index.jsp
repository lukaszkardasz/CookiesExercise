<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 13/12/2019
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
          pageEncoding="UTF-8" %>
<%@ page session="false" %> <%--nie potrzebujemy aby strona zapamiętywała sesję np faq.jsp lub about.jsp, względyu wydajnościowe i bezpieczeństwa - ddos może wygenerować wiele sesji w krótkim czasie--%>
<!DOCTYPE html>
<html>
  <head>
    <title>Homepage</title>
  </head>
  <body>
  <a href="CookieServlet?cookie=create">Create and save next cookie</a>
  <br/>
  <a href="CookieServlet?cookie=print">Check cookie</a>
  <br/>
  <a href="CookieServlet?cookie=remove">Remove cookies</a>
  </body>
</html>