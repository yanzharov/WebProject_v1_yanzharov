package by.tr.op.service;

import by.tr.op.bean.Information;
import by.tr.op.service.exception.ServiceException;

public interface EditUserService {
    
    Information addNewUser(String name, String login, String password, String role) throws ServiceException;
    
}
