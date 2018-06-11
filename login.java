package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uname= request.getParameter("uname");
			String pass= request.getParameter("pass");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "swaraj123");
			Statement st=con.createStatement();
			String sql="select * from login";
			ResultSet rs=st.executeQuery(sql);
			System.out.println(uname+pass);
			String s1,s2;
			while(rs.next()) {
				s1=rs.getString(2);
				s2=rs.getString(3);
				if(uname.equals(s1) && pass.equals(s2)) {
					response.sendRedirect("welcome.jsp");
					System.out.println("entering");
					
				}
				
				
			
		    }
			response.sendRedirect("loginPage.jsp");
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
