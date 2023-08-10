package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet implementation class FibonnaciNeeraj
 */
public class FibonnaciNeeraj extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static int fibi(int n) {
		if(n==0 || n==1)
		{
			return n;
		}
		else {
			return fibi(n-1)+fibi(n-2);
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		if (request.getParameter("formLimit") == null) {
			out.println(
					"This is not the way to access this resource. Please give a value for the parameter 'n' in your query ");
			return;
		} else {
			String input = request.getParameter("n");
			int num = Integer.valueOf(input);
			List<Integer> fibList = new ArrayList<>();
			for (int i = 0; i <= num; i++) {
				int ans = fibi(i);
				fibList.add(ans);
			}
			out.println(fibList.stream()
						   	   .map(Object::toString)
						       .collect(Collectors.joining(", "))
						   );
		}
	}
	
	 @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    PrintWriter out = response.getWriter();
	    
	    String param = request.getParameter("formLimit");
	    
	    try {
	    	int num = Integer.parseInt(param);
	    	for(int i=0;i<num;i++) {
	    		out.print(String.format("<p> %d </p>", fibi(i)));
	    	}
	    }catch(NumberFormatException e)
	    {
	    	out.println("Invalid");
	    }
	    
//	    if (request.getParameter("formLimit") == null) {
//	      out.println("This is not the way to access this resource. Please give a value for the parameter 'n' in your query ");
//	      return;
//	    } else {
//	    	
//	      int limit = Integer.valueOf(request.getParameter("formLimit"));
//	      out.println(String.format("<p>%s</p>", fibi(limit)));
//	    }
	  }
		
		
		
		


	}

	