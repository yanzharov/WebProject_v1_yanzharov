<%@page import="by.tr.op.bean.Information"%>
<%@page import="by.tr.op.controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
      <c:out value="${sessionScope.userInformation.errorMessage}" />
    <div class="hello-block">
      <c:if test="${sessionScope.userInformation.active != null && sessionScope.userInformation.active==true}">
        <h1 class="hello-user">Здравствуйте user-<c:out value="${sessionScope.userInformation.userId}"/></h1>
        <div class="hello-block-authorization">
          <a href="Controller?commandName=SIGN_OUT">Выйти из системы</a>
          <a href="Controller?commandName=GET_POLLS">Просмотреть опросы</a>
        </div>
      </c:if>
      <c:if test="${sessionScope.userInformation.active == null || sessionScope.userInformation.active==false}">
        <h1>Вы зашли как неавторизированный пользователь</h1>
        <a href="jsp/authorization.jsp">Авторизироваться</a>
        <a href="jsp/registration.jsp">Зарегистрироваться</a>
        <a href="Controller?commandName=GET_POLLS">Просмотреть опросы</a>
      </c:if>
    </div>
  </body>
</html>
