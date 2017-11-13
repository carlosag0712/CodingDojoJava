package io.agileintelligence.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.agileintelligence.com.models.Cat;

/**
 * Servlet implementation class Cat
 */
@WebServlet("/gato")
public class CatCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catName = request.getParameter("name");
		String catBreed = request.getParameter("breed");
		double catWeight = Double.parseDouble(request.getParameter("weight"));
		
		Cat c = new Cat(catName, catBreed, catWeight);
		
		request.setAttribute("cat", c);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Cat.jsp");
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
