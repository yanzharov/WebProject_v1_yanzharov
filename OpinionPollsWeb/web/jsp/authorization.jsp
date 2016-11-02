<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/style.css">
  </head>
  <body>
    <form action="${pageContext.servletContext.contextPath}/Controller" method="post">
      <table id="login_table">
        <tbody>
          <tr><td>
            <table cellpadding="0" cellspacing="20" width="400">
              <tbody>
                <tr>
                  <td></td>
                  <td class="auth_title" colspan="2">Авторизация</td>
                </tr>
                <tr>
                  <td >
                  <input name="commandName" type="hidden" value="SIGN_IN" />
                  </td>
                </tr>
                <tr>
                  <td class="auth_cell_titles">Логин</td>
                  <td class="auth_cell" width="100%">
                    <input name="login" style="width: 100%;" class="auth" type="text" />
                  </td>
                </tr>
                <tr>
                  <td class="auth_cell_titles">Пароль</td>
                  <td class="auth_cell">
                    <input name="password" style="width: 100%;" class="auth" type="password" />
                  </td>
                </tr>
                <tr>
                  <td></td>
                  <td class="auth_submit" align="left">
                    <input value="Войти" name="submit" id="auth_submit_button" type="submit" />
                  </td>
                </tr>
              </tbody>
            </table>
          </td></tr>
        </tbody>
      </table>
    </form>
  </body>
</html>
