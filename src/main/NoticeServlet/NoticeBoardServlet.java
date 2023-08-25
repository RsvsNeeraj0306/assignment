package com.learning.NoticeServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebServlet("/notice")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	NoticeController n = new NoticeController();
	NoticeController n6 = new NoticeController();
	NoticeController n2 = new NoticeController();
	NoticeController n3 = new NoticeController();
	NoticeController n4 = new NoticeController();
	NoticeController n5 = new NoticeController();
	public int id;
	public String name;
	public String number;
	public String comment;
	public int count=0;

	static {

		try {

			// Load the MySQL JDBC driver

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void init() throws ServletException {
		super.init();

		
		application = JakartaServletWebApplication.buildApplication(getServletContext());
		final WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		var out = res.getWriter();
		final IWebExchange webExchange = this.application.buildExchange(req, res);
		final WebContext ctx = new WebContext(webExchange);
		ctx.setVariable("getcard1", n.getName());
		ctx.setVariable("getcard2", n2.getName());
		ctx.setVariable("getcard3", n3.getName());
		ctx.setVariable("getcard4", n4.getName());
		ctx.setVariable("getcard5", n5.getName());
		ctx.setVariable("getcard6", n6.getName());
		
		templateEngine.process("Notice", ctx, out);

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		final IWebExchange webExchange = this.application.buildExchange(req, res);
		final WebContext ctx = new WebContext(webExchange);
		
		//n.saveNotice(name,temp,content);

		System.out.println(req.getParameter("button").equals("Submit"));
		if (req.getParameter("button").equals("Submit")) {
			String name = req.getParameter("name");
			String temp = req.getParameter("number");
			String content = req.getParameter("content");
			n.saveNotice(name,temp,content);
			n.selectQuery();
			System.out.println(n.getName() + "Name");
			System.out.println("count: "+count);
			count++;
			if(count==1) {
				ctx.setVariable("getcard1", n.getName());
			}
			else if(count==2) {
				ctx.setVariable("getcard2", n2.getName());
			}
			else if(count==3) {
				ctx.setVariable("getcard3", n3.getName());
			}
			else if(count==4) {
				ctx.setVariable("getcard4", n4.getName());
			}
			else if(count==5) {
				ctx.setVariable("getcard5", n5.getName());
			}
			else if(count==6) {
				ctx.setVariable("getcard6", n6.getName());
				count=0;
			}
			
		}

		doGet(req, res);
	}

	

	

}

