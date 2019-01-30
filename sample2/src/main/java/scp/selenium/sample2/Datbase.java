package scp.selenium.sample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Datbase {
	
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
					statement.execute("INSERT INTO EMPLOYEE VALUES("+i+",'prashant"+i+"','Satara"+i+"')");
			}
			System.out.println("Data enterd successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//closeConnectionNStmt(statement, connection);
		}
		
	}
	public static void DeleteRecord() {
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
	public static void insertRecordInStudent(int no) {
		Connection connection = getConnection();
		Statement statement =null;
		try {
			statement = connection.createStatement();
			for(int i=1;i<=no;i++){
					statement.execute("INSERT INTO STUDENT1 VALUES("+i+",'prashant"+i+"',152685245"+i+")");
			}
			System.out.println("Data enterd successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//closeConnectionNStmt(statement, connection);
		}
		
	}
	public static void FechDataFomTable(){

		Connection connection = getConnection();
		Statement stmt =null;
		ResultSet resultSet = null;
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			System.out.println("EMP_ID : "+"\t"+"EMP_ADDRESS: "+"\t"+"EMP_NAME : ");
			while(resultSet.next()){
				int i= resultSet.getInt("EMP_ID");
				String s = resultSet.getString("EMP_ADDRESS");
				String s2 = resultSet.getString("EMP_NAME");
				System.out.println(i+"\t\t" +s+"\t\t"+s2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	/*public static List<Emp> fetchAllDataFromDB() {
		Connection connection = getConnection();
		Statement stmt =null;
		ResultSet resultSet = null;
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			Emp emp = null;
			List<Emp> listOfemps = new ArrayList<Emp>();
			while(resultSet.next()){
				emp = new Emp();
				emp.setEmpId(resultSet.getInt("EMP_ID"));
				emp.setEmpAddress(resultSet.getString("EMP_ADDRESS"));
				emp.setEmpName(resultSet.getString("EMP_NAME"));
				listOfemps.add(emp);
				System.out.println("data fatch successfilly");
				System.out.println(listOfemps);
			}
			return listOfemps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}*/
	

}

