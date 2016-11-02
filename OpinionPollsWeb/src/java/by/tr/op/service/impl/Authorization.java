package by.tr.op.service.impl;

import by.tr.op.bean.Information;
import by.tr.op.dao.DAOFactory;
import by.tr.op.dao.PollsDAO;
import by.tr.op.dao.exception.DAOException;
import by.tr.op.service.AuthorizationService;
import by.tr.op.service.exception.ServiceException;

public class Authorization implements AuthorizationService{

    @Override
    public Information signIn(String login, String password) throws ServiceException {
        int userId; 
        Information information=new Information();
        
        if(!login.matches("^[a-zA-Z0-9]+$")){
            information.setUserId(-1);
            information.setErrorMessage("Неправильный логин");
            return information;
        }
        if(!password.matches("^[a-zA-Z0-9]+$")){
            information.setUserId(-1);
            information.setErrorMessage("Неправильный пароль");
            return information;
        }
        
        DAOFactory factory=DAOFactory.getInstance();
        PollsDAO pollsDao=factory.getPollsDao();
        
        try{
            userId=pollsDao.signIn(login, password);
            information.setUserId(userId);
        }
        catch(DAOException e){
            throw new ServiceException(e);
        }
        
        return information;
    }
    
}
