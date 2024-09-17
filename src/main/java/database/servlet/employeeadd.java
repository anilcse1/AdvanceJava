package database.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class employeeadd
 */
@WebServlet("/employeeadd")
public class employeeadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		ResultSet result = Connection.prepareCall(sql);
//		int id = result.getInt("employee_id");
//		String name = result.getString("employee_name");
//		String plc = result.getString("employee_place");
//		String addrs = result.getString("employee_address");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String employee_name = request.getParameter("employee_name");
		String employee_place = request.getParameter("employee_place");
		String employee_address = request.getParameter("employee_address");
		String username = "root";
		String password = "apcl123456";
		String url = "jdbc:mysql://localhost:3306/anil";		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection(url,username,password);
			 
			String sql = "insert into employee(employee_id,employee_name,employee_place,employee_address) values(?,?,?,?)";
			PreparedStatement stnt = con.prepareStatement(sql);
			stnt.setInt(1, employee_id);
			stnt.setString(2, employee_name);
			stnt.setString(3, employee_place);
			stnt.setString(4, employee_address);
			int data = stnt.executeUpdate();
			PrintWriter out = response.getWriter();
			if(data>0)
			{
				out.print("record added");
			}
			else
			{
				out.print("Error");
			}
			
			
		} catch (ClassNotFoundException |  SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
