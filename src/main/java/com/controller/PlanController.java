package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.PlanDao;
import com.model.Plan;

/**
 * Servlet implementation class PlanController
 */
@WebServlet("/PlanController")
public class PlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String opcion = request.getParameter("opcion");
	
			if(opcion.equals("obtener")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/PlanController.jsp");
				requestDispatcher.forward(request, response);
				
		}else {
			if(opcion.equals("crearPlan")){
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/crearPlan.jsp");
				requestDispatcher.forward(request, response);
				
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion= request.getParameter("opcion1");
		Plan pl = new Plan();
		PlanDao pld= new PlanDao();
		
		pl.setIdPlan(Integer.parseInt(request.getParameter("idPlan")));
		pl.setNombre(request.getParameter("nombrePlan"));
		pl.setImportef(Float.parseFloat(request.getParameter("costo")));
		
		
		try {
			pld.guardar(pl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
