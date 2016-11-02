<%@page import="by.tr.op.controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/style.css">
  </head>
  <body>
    <h1 class="polls-title">Социологические опросы</h1>
    <table class="simple-little-table" cellspacing='0'>
      <tr>
        <th>Тема</th>
        <th>Статус</th>
        <th>Дата создания</th>
      </tr>
      <c:forEach var="poll" items="${requestScope.information.polls}">
        <tr>
          <td><c:out value="${poll.theme}"/></td>
          <td><c:out value="${poll.state}"/></td>
          <td><c:out value="${poll.date}"/></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
