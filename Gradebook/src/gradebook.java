

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gradebook
 */
@WebServlet("/gradebook")
public class gradebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ResultSet result = null;
		String sql = "";
		String message = "";
		int sum = 0;
		double avg = 0;
		
		
		String assgn = request.getParameter("assignment");
		String grd = request.getParameter("grade");

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    //URL of Oracle database server
	    String url = "jdbc:oracle:thin:testuser/password@localhost"; 

	    
	    //properties for creating connection to Oracle database
	    Properties props = new Properties();
	    props.setProperty("user", "testdb");
	    props.setProperty("password", "password");
	  
	    //creating connection to Oracle database using JDBC
	    Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,props);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	  
		
		
		
		sql = "INSERT INTO grades (assignment, grade)"+
				"VALUES('"+assgn+"',"+grd+")";
	
		    //creating PreparedStatement object to execute query
		
		    PreparedStatement preStatement = null;
			try {
				preStatement = conn.prepareStatement(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				result = preStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	   
			sql = "SELECT * FROM grades";
			preStatement = null;
			try {
				preStatement = conn.prepareStatement(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				result = preStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int counter = 0;
			try {
				message= "<thead><tr><th>Asignment</th><th>Grade</th></tr></thead>";
				while(result.next()){
				    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
					//System.out.printf("%s %s, %s\n",
					sum += result.getDouble("GRADE");
					counter++;
					message += "<tr><td>"+result.getString("ASSIGNMENT")+"</td><td>"+result.getDouble("GRADE")+"</td></tr>\n";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			avg = sum/counter; 
			
			/*
			try {
				message= "<thead><tr><th>Asignment</th><th>Grade</th></tr></thead>";
				while(result.next()){
				    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
					//System.out.printf("%s %s, %s\n",
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			System.out.println(message);
		  response.setContentType("text/html");
	      request.setAttribute("avg", avg);
	    
	      request.setAttribute("message", message);
	      getServletContext()
	      .getRequestDispatcher("/average.jsp")
	      .forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		
	}

	public static ResultSet sqlConnection(Connection conn, String sql)
	{
		ResultSet result = null;
		PreparedStatement preStatement = null;
		try {
			preStatement = conn.prepareStatement(sql);
			result = preStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}

}
