package com.servlets.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String eid = request.getParameter("id");
		Integer empid = Integer.parseInt(eid);
		String firstname = request.getParameter("fn");
		String email = request.getParameter("em");
		String password = request.getParameter("pw");
		String phone = request.getParameter("ph");
		long phonenumber = Long.parseLong(phone);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?", "root", "root");
			PreparedStatement pst = con.prepareStatement("insert into serv values(?,?,?,?,?)");
			pst.setInt(1, empid);
			pst.setString(2, firstname);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.setLong(5, phonenumber);
			pst.executeUpdate();
			pw.print("Registration Successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			pw.print("registration failed pls try again");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pw.print("registration failed pls try again");
		}
	}

}
