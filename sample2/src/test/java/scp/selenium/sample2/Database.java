package scp.selenium.sample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	static public Connection getConnection(){
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
	public static void insertRecordInTable(int no) {
		Connection connection = getConnection();
		Statement statement =null;
		try {
			statement = connection.createStatement();
			for(int i=1;i<=no;i++){
					statement.execute("INSERT INTO EMPLOYEE VALUES("+i+",'prashant"+i+"','Satara"+i+"')");
			}
			System.out.println("Data enterd successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//closeConnectionNStmt(statement, connection);
			
		}
		
	}
	public static void DeleteRecords() {
		Connection connection = getConnection();
		Statement statement =null;
		try {
			statement = connection.createStatement();
			statement.executeQuery("delete from EMPLOYEE");
			System.out.println("record deleted successfuly");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<Emp1> fetchAllDataFromDatabase() {
		Connection connection = getConnection();
		Statement stmt =null;
		ResultSet resultSet = null;
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			Emp1 emp = null;
			List<Emp1> listOfemps = new ArrayList<Emp1>();
			while(resultSet.next()){
				emp = new Emp1();
				emp.setEmpId(resultSet.getInt("EMP_ID"));
				emp.setEmpAddress(resultSet.getString("EMP_ADDRESS"));
				emp.setEmpName(resultSet.getString("EMP_NAME"));
				listOfemps.add(emp);
			}
			return listOfemps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	public static List<List<Object>> fetchAllDataFromDatabase1() {
		Connection connection = getConnection();
		Statement stmt =null;
		ResultSet resultSet = null;
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			List<Object> emp = null;
			List<List<Object>> listOfemps = new ArrayList<>();
			while(resultSet.next()){
				emp = new ArrayList<>();
				emp.add(resultSet.getInt("EMP_ID"));
				System.out.println(resultSet.getInt("EMP_ID"));
				emp.add(resultSet.getString("EMP_ADDRESS"));
				emp.add(resultSet.getString("EMP_NAME"));
				listOfemps.add(emp);
			}
			return listOfemps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
