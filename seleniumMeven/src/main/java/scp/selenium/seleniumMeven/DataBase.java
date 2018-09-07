package scp.selenium.seleniumMeven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataBase {
	public static void main(String[] args) {
		DataBase.getConnection();
		DataBase.createTable();
		DataBase.insertRecordInDb(10);
	}
	
	static private Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
			
			if(connection!=null)
				System.out.println("Connection created Successfully");
			
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("There is some problem with DB Connection");
			return null;
		}
	}
	@SuppressWarnings("unused")
	private static void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			if(connection!=null) {
				statement = connection.createStatement();
				String createTableQuery="CREATE TABLE tutorials_tbl (\r\n" + 
						"   id INT NOT NULL,\r\n" + 
						"   title VARCHAR(50) NOT NULL,\r\n" + 
						"   author VARCHAR(20) NOT NULL,\r\n" + 
						"   submission_date DATE,\r\n" + 
						"   PRIMARY KEY (id) \r\n" + 
						")";
				statement.executeQuery(createTableQuery);
			}
			System.out.println("table created Successfuly");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertRecordInDb(int no) {
		Connection connection = getConnection();
		Statement statement =null;
		try {
			statement = connection.createStatement();
			for(int i=1;i<=no;i++){
					statement.execute("INSERT INTO EMPLOYEE VALUES("+i+",'prashant"+i+"','Karad"+i+"')");
			}
			System.out.println("Data enterd successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//closeConnectionNStmt(statement, connection);
		}
	}
	
		
	
}


