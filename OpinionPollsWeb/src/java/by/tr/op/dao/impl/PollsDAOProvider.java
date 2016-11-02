package by.tr.op.dao.impl;

import by.tr.op.bean.Poll;
import by.tr.op.dao.ConnectionPoolFactory;
import by.tr.op.dao.connection.ConnectionPool;
import by.tr.op.dao.PollsDAO;
import by.tr.op.dao.exception.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollsDAOProvider implements PollsDAO{
    private final static String SELECT_USER_ID_QUERY="SELECT `id` FROM `users` WHERE `login`=? AND `password`=?";
    private final static String INSERT_USER_QUERY="INSERT INTO `users`(`id`,`name`,`login`,`password`,`role`) VALUES(?,?,?,?,?)";
    private final static String SELECT_MAX_ID_QUERY="SELECT MAX(`id`) FROM `users`";
    private final static String SELECT_POLLS_QUERY="SELECT `id`,`theme`,`author_id`,`state`,`date` FROM `opinion_polls`";
    
    
    @Override
    public int signIn(String login, String password) throws DAOException {
        ConnectionPoolFactory factory=ConnectionPoolFactory.getInstance();
        ConnectionPool conPool=factory.getConnectionPool();
        Connection con=null;
        
        try{
            con=conPool.retrieve();           
            PreparedStatement st=con.prepareStatement(SELECT_USER_ID_QUERY);
            
            st.setString(1,login);
            st.setString(2, password);
            
            ResultSet set=st.executeQuery();
            if(set.next()){
                return set.getInt(1);
            }
            else{
                return -1;
            }
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
        catch(NullPointerException e){
            throw new DAOException(e);
        }
        finally{
            conPool.putback(con);
        }
    }

    @Override
    public void addNewUser(int id, String name, String login, String password, String role) throws DAOException {
        ConnectionPoolFactory factory=ConnectionPoolFactory.getInstance();
        ConnectionPool conPool=factory.getConnectionPool();
        Connection con=null;
        
        try{
            con=conPool.retrieve();    
            PreparedStatement st=con.prepareStatement(INSERT_USER_QUERY);
            
            st.setInt(1,id);
            st.setString(2, name);
            st.setString(3, login);
            st.setString(3, login);
            st.setString(4, password);
            st.setString(5,role);
            
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
        catch(NullPointerException e){
            throw new DAOException(e);
        }
        finally{
            conPool.putback(con);
        }
    }

    @Override
    public int getUserCount() throws DAOException {
        ConnectionPoolFactory factory=ConnectionPoolFactory.getInstance();
        ConnectionPool conPool=factory.getConnectionPool();
        Connection con=null;
        
        try{
            con=conPool.retrieve();
            PreparedStatement st=con.prepareStatement(SELECT_MAX_ID_QUERY);

            ResultSet set=st.executeQuery();
            if(set.next()){
                return set.getInt(1);
            }
            else{
                return -1;
            }
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
        catch(NullPointerException e){
            throw new DAOException(e);
        }
        finally{
            conPool.putback(con);
        }
    }

    @Override
    public List<Poll> getPolls() throws DAOException {
        ConnectionPoolFactory factory=ConnectionPoolFactory.getInstance();
        ConnectionPool conPool=factory.getConnectionPool();
        Connection con=null;
        List list=new ArrayList();
        Poll poll=null;
        
        try{
            con=conPool.retrieve();
            PreparedStatement st=con.prepareStatement(SELECT_POLLS_QUERY);
            
            ResultSet set=st.executeQuery();
            while(set.next()){
                poll=new Poll();
                poll.setId(set.getInt(1));
                poll.setTheme(set.getString(2));
                poll.setAuthorId(set.getInt(3));
                poll.setState(set.getString(4));
                poll.setDate(set.getDate(5));
                list.add(poll);
            }
            
            return list;
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
        catch(NullPointerException e){
            throw new DAOException(e);
        }
        finally{
            conPool.putback(con); 
        }
    }
    
    
    
}
