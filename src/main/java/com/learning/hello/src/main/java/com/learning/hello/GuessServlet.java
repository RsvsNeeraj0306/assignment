package com.learning.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GuessServlet")
public class GuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int targetNumber;
    
    public GuessServlet() {
        super();
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String guessParameter = request.getParameter("guess");
        
        if (guessParameter != null && !guessParameter.isEmpty()) {
            int userGuess = Integer.parseInt(guessParameter);
            System.out.println("guess:"+userGuess+"targetNumber:"+targetNumber);
            String message = compareGuess(userGuess);

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.print(message);
            out.flush();
        } 
    }
    
    
    protected void doget(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String guessParameter = request.getParameter("guess");
        
        if (guessParameter != null && !guessParameter.isEmpty()) {
            int userGuess = Integer.parseInt(guessParameter);
            System.out.println("guess:"+userGuess+"targetNumber:"+targetNumber);
            String message = compareGuess(userGuess);

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.print(message);
            out.flush();
        } 
    }
    
    
    
    
    

    
    private String compareGuess(int guess) {
        if (guess == this.targetNumber) {
            return "Congratulations! You guessed the correct number.";
        } else if (guess < targetNumber) {
            return "Try a higher number.";
        } else {
            return "Try a lower number.";
        }
    }
}
