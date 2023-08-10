package com.learning.hello;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class PasswordCrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password;
		String Path = "/home/neeraj/eclipse-workspace/learning-web/src/main/java/com/learning/hellopassword.txt";
		String confirmPassword = request.getParameter("password");
		PrintWriter o = response.getWriter();
		BufferedReader read = new BufferedReader(new FileReader(Path));
		boolean ans = false;
		o.println("<html> <body>");
		while ((password = read.readLine()) != null) {
			if (password.equals(confirmPassword)) {
				ans = true;
			}
		}
		if (ans)
			o.println(" your password ok");
		else
			o.println(" your password is blocked");


	}

}
