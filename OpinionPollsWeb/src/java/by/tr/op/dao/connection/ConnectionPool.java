package by.tr.op.dao.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final static String DRIVER="com.mysql.jdbc.Driver";
    private final static String URL="jdbc:mysql://localhost/mydatabase";
    private final static String USER="root";
    private final static String PASSWORD="root";
    private List<Connection> availableConns=new ArrayList<Connection>();

    public ConnectionPool(int initConCount) {
        try {
	    Class.forName(DRIVER);
	} 
        catch (ClassNotFoundException e) {

	}
        for (int i = 0; i < initConCount; i++) {
	    availableConns.add(getConnection());
	}
    }
    
    private Connection getConnection() {
	Connection con = null;
	try {
	    con=DriverManager.getConnection(URL,USER,PASSWORD);
	} 
        catch (SQLException e) {
	
	}
	return con;
    }
    
    public synchronized Connection retrieve() throws SQLException {
	Connection newCon=null;
        
	if (availableConns.size() == 0) {
  	    newCon=getConnection();
	} 
        else {
	    newCon=availableConns.remove(0);
	}
        
	return newCon;
    }
    
    public synchronized void putback(Connection c){
	if (c != null) {
	    availableConns.add(c);
	} 
    }

    public synchronized int getAvailableConnsCnt() {
	return availableConns.size();
    }
    
}
