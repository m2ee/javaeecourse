package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassanger
 */
@WebServlet("/AddPassanger")
public class AddPassanger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassanger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passanger.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first-name");
		System.out.println("First Name: " + firstName);

		String lastName = request.getParameter("last-name");
		System.out.println("Last Name: " + lastName);
		
		String dob_row = request.getParameter("dob");
		String[] dobArray = dob_row.split("\\/");
		
		String month = dobArray[0];
		String day   = dobArray[1];
		String year  = dobArray[2];
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		
		//Date dob = cal.getTime();
		System.out.println("Date : " + cal.getTime());
		
		String gender = request.getParameter("gender");
		System.out.println("Gender : " + gender);

		
		
		
		doGet(request, response);
	}

}
