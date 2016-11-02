package by.tr.op.dao;

import by.tr.op.bean.Poll;
import by.tr.op.dao.exception.DAOException;
import java.util.List;

public interface PollsDAO {
    
    int signIn(String login,String password) throws DAOException;
    void addNewUser(int id,String name,String login,String password,String role) throws DAOException;
    int getUserCount() throws DAOException;
    List<Poll> getPolls() throws DAOException;
    
}
