package com.learning.CardGame;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebServlet("/cardgame")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	private Deck d;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		d = new Deck();
		application = JakartaServletWebApplication.buildApplication(getServletContext());
		final WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final IWebExchange webExchange = this.application.buildExchange(request, response);
		final WebContext ctx = new WebContext(webExchange);
		templateEngine.process("Game", ctx, response.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
		var out = response.getWriter();
		final IWebExchange webExchange = this.application.buildExchange(request, response);
		final WebContext ctx = new WebContext(webExchange);
		if (request.getParameter("button").equals("Enter")) {
			ctx.setVariable("getinpile",d.getInpile());
			System.out.println(d.getInpile());
			ctx.setVariable("getoutpile",d.getOutpile());
			System.out.println(d.getOutpile());
			
		}
		else if(request.getParameter("button").equals("Set Card"))
		{
			ctx.setVariable("getcard", d.getRandomCard());
			System.out.println(d.getRandomCard());
		}
		
		if(d.getInpile().equals(d.getRandomCard())) {
			
			ctx.setVariable("feedback", d.getInpileResult());
		}
		
		else if(d.getOutpile().equals(d.getRandomCard())) {
			ctx.setVariable("feedback", d.getOutpileResult());
		}
		templateEngine.process("Game", ctx, out);
	}

}
