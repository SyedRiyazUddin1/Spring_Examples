package com.firstwebapp;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


//Servlet defination: It is a Java class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	// creating an instance of UserValidationService class
	private UserValidationService service = new UserValidationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// doGet() method is used for getting the information from server

		// System.out.println(request.getParameter("name")); //you will get the parameter passed in the browser to the console
		// Whatever parameter we passed in the url can be seen in the body of the JSP
		// //String name = request.getParameter("name");
		// request.setAttribute("name", request.getParameter("name"));
		// request.setAttribute("password", request.getParameter("password"));

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isUserValid = service.validateUser(name, password); //using the service here to validate the username and password

		// if the name and password inputs matches, it will redirect to
		// welcome.jsp
		if (isUserValid) {
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
		
		// else, it will redirect to the login.jsp page again with an error
		// message
		else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}
}
