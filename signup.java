package com.signUp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("uname");
		String pass=request.getParameter("pass");
		int id = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "swaraj123");
			Statement st=con.createStatement();
			String sql="select * from login";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				id=rs.getInt(1);
			}
			id++;
			sql="insert into login values("+String.valueOf(id)+",'"+uname+"','"+pass+"')";
			rs=st.executeQuery(sql);
			response.sendRedirect("loginPage.jsp");
		}
		catch(Exception e) {
			System.out.print(e);
		}

	}

}
