package by.tr.op.service.impl;

import by.tr.op.bean.Information;
import by.tr.op.dao.DAOFactory;
import by.tr.op.dao.PollsDAO;
import by.tr.op.dao.exception.DAOException;
import by.tr.op.service.EditUserService;
import by.tr.op.service.exception.ServiceException;

public class EditUser implements EditUserService{

    @Override
    public Information addNewUser(String name, String login, String password, String role) throws ServiceException {
        Information information=new Information();
        
        if (name == null || "".equals(name)){
	    information.setUserId(-1);
            information.setErrorMessage("Неправильное имя");
            return information;
	}
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
            int count=pollsDao.getUserCount();
            if(count!=-1){
                pollsDao.addNewUser(count+1, name, login, password, role);
                information.setUserId(count+1);
                return information;
            }
            else{
                information.setUserId(-1);
                information.setErrorMessage("Ошибка добавления нового пользователя");
                return information;
            }
        }
        catch(DAOException e){
            throw new ServiceException(e);
        }
        
    }
    
}
