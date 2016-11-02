package by.tr.op.command.impl;

import by.tr.op.command.Command;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOut implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        session.invalidate();
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
	requestDispatcher.forward(request, response);
    }
    
}
