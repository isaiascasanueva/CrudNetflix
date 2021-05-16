package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.SubsDao;
import com.model.Plan;
import com.model.Subscritor;

/**
 * Servlet implementation class SubscritorController
 */
@WebServlet(description = "administra peticiones para la tabla subs", urlPatterns = { "/Subscritor" })
public class SubscritorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscritorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String opcion = request.getParameter("opcion");
		if(opcion.equals("crear")) {
			//System.out.println("Usted quiere crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/crear.jsp");
			requestDispatcher.forward(request, response);
		}else {
			if(opcion.equals("listar")) {
				System.out.println("Usted quiere listar");
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion= request.getParameter("opcion");
		Plan pl = new Plan();
		
		SubsDao subsDao = new SubsDao();
		
		Subscritor sub = new Subscritor();
		
		sub.setNombre(request.getParameter("nombre"));
		sub.setApellidoPaterno(request.getParameter("apellidoPaterno"));
		sub.setApellidoMaterno(request.getParameter("apellidoMaterno"));
		sub.setServicio(request.getParameter("servicio"));
		sub.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		//sub.setPlan(new Plan(Integer.parseInt(request.getParameter("1")),request.getParameter("Maximo"),(float) Double.parseDouble(request.getParameter("500"))));
		sub.setEstatus(request.getParameter("estatus"));
		
		try {
			subsDao.guardar(sub);
			System.out.println("Se a guardado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
