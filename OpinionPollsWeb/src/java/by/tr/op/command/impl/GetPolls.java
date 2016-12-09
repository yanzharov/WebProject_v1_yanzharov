
package by.tr.op.command.impl;

import by.tr.op.bean.Information;
import by.tr.op.bean.Poll;
import by.tr.op.command.Command;
import by.tr.op.service.FindPollService;
import by.tr.op.service.exception.ServiceException;
import by.tr.op.service.factory.ServiceFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPolls implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Information information=new Information();
        ServiceFactory factory=ServiceFactory.getInstance();
        FindPollService findPollService=factory.getFindPollService();
        List<Poll> list;
        
        try{
            information=findPollService.getPolls();
        }
        catch(ServiceException e){
            information.setErrorMessage("Ошибка получения опросов");// почему на русском?
		// и зачем ради ошибки использовать объект information
		// тебе requesta мало?
        }
        
        request.setAttribute("information", information);
	    
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/polls.jsp");
	requestDispatcher.forward(request, response);
    }
    
}
