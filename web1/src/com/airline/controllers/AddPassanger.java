package com.airline.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airiline.models.Gender;
import com.airiline.models.Passenger;

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
		request.setAttribute("errors",false);
		
		Passenger p = new Passenger();
		String firstName = request.getParameter("first-name");
		
		
		if(firstName.length() == 0){
			System.out.println("empty first name error");
			request.setAttribute("errors",true);
			request.setAttribute("firstName error",true);
		} else {
			 System.out.println("First Name: " + firstName);
			 p.setFirstName(firstName);
		}

		String lastName = request.getParameter("last-name");
		
		if(lastName.length() == 0){
			System.out.println("empty last name error");
			request.setAttribute("errors",true);
			request.setAttribute("lastName error",true);
		} else {
			 System.out.println("Last Name: " + lastName);
			 p.setLastName(lastName);
		}
		
		String dob_row = request.getParameter("dob");
		String[] dobArray = dob_row.split("\\/");
		
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(dob_row);
		
		if(m.find()){
			String month = dobArray[0];
			String day   = dobArray[1];
			String year  = dobArray[2];
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			
			Date dob = cal.getTime();
			System.out.println("Date : " + cal.getTime());
			p.setDob(dob);
		} else {
			System.out.println("date error");
			request.setAttribute("errors",true);
			request.setAttribute("date error",true);
		}
		

		
		String gender = request.getParameter("gender");
		System.out.println("Gender : " + gender);
        p.setGender(Gender.valueOf(gender));
		
		if((Boolean)request.getAttribute("errors")){
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passanger.jsp");
			view.forward(request, response);
		} else{
			
			ServletContext sc = this.getServletContext();
			
			ArrayList<Passenger> pList = new ArrayList();
			pList.add(p);
			
			sc.setAttribute("passangers", pList);
			
			response.sendRedirect("");
		}
		
	}

}
