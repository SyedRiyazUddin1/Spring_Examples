package com.jspservlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspservlet.dao.StudentDetails;

public class LoginServlet extends HttpServlet {

		/**
		 * 
		 */
		   private static final long serialVersionUID = 1L;

		public LoginServlet() {
			super();
			// TODO Auto-generated constructor stub
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username.isEmpty() || password.isEmpty()) {
				RequestDispatcher req = request.getRequestDispatcher("error.jsp");
				req.include(request, response);
			} else {
				RequestDispatcher req = request.getRequestDispatcher("login_sucess.jsp");
				req.forward(request, response);
			}
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("Inside Servlet");

			String type = request.getParameter("type");

			if (type.equals("getDetails")) {

				StudentDetails stuDetails = new StudentDetails(0, 0, type, type);

				stuDetails.getStudentDetails();

				request.setAttribute("stuList", stuDetails.getStudentDetails());

				request.getRequestDispatcher("student_details.jsp").forward(request, response);
			}
		}


}
