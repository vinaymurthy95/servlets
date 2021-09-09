package com.servlets.assignments;

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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("em");
		String pass = request.getParameter("pw");
		String phone = request.getParameter("ph");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?", "root", "root");
			PreparedStatement pst = con.prepareStatement("update serv set phone= ? where email=? and password=?");
			pst.setString(1, phone);
			pst.setString(2, email);
			pst.setString(3, pass);
			System.out.println("4.Query Executed");
			int row = pst.executeUpdate();
			if (row > 0) {
				pw.print("record updated successfully");
			} else {
				pw.print("record not found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
