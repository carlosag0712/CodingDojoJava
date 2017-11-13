package io.agileintelligence.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.agileintelligence.com.models.Dog;

/**
 * Servlet implementation class DogCtrl
 */
@WebServlet("/dog")
public class DogCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DogCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogName = request.getParameter("name");
		String dogBreed = request.getParameter("breed");
		double dogWeight = Double.parseDouble(request.getParameter("weight"));
		
		Dog d = new Dog(dogName, dogBreed, dogWeight);
		
		request.setAttribute("dog", d);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Dog.jsp");
		
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
