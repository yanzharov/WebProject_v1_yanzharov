package by.tr.op.command.impl;

import by.tr.op.bean.Information;
import by.tr.op.command.Command;
import by.tr.op.service.EditUserService;
import by.tr.op.service.exception.ServiceException;
import by.tr.op.service.factory.ServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddNewUser implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId=-1;
        Information information=new Information();
        HttpSession session=request.getSession();
        ServiceFactory factory=ServiceFactory.getInstance();
        EditUserService editUserService=factory.getEditUserService();
        
        String name=request.getParameter("name");
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        
        try{
            information=editUserService.addNewUser(name,login,password,role);
            userId=information.getUserId();         
        }
        catch(ServiceException e){
            information.setErrorMessage("Ошибка добавления нового пользователя");
        }
        
        if(userId!=-1){
            information.setActive(true);
        }
        
        session.setAttribute("userInformation", information);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
	requestDispatcher.forward(request, response);
    }
    
}
