package database.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginsearch
 */
@WebServlet("/loginsearch")
public class loginsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginsearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		int id = request.getInt("employee_id");
	    String name = request.getParamater("employee_name");
    	String plc = request.getParamater("employee_place");
		String addrs = request.getParamater("employee_address");
		int id = Integer.parseInt(request.getParameter("id"));
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection(url,username,password);
		 Statement st = con.createStatement();
		 String sql = "Select * from employee where id = ?";
		 PreparedStatement smt = con.prepareStatement(sql);
		 smt.setInt(1, id);
		 ResultSet res = smt.executeQuery();
		 
		 while(res.next())
		 {
			 int id1 = res.getInt("employee_id");
			 String name = res.getString("employee_name");
			 String place = res.getString("employee_place");
			 String address = res.getString("employee_address");
			 
			 out.print(id1);
			 out.print(name);
			 out.print(place);
			 out.print(address);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
