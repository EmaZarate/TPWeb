package Servlets;

import java.io.IOException;
import java.security.Permissions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import Controlador.ControladorJuego;
import Entidades.Personaje;

/**
 * Servlet implementation class SeleccionarPersonajes
 */
@WebServlet("/SeleccionarPersonajes")
public class SeleccionarPersonajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarPersonajes() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(true);
		 
	    ControladorJuego ctrl= new ControladorJuego();
	    session.setAttribute("ctrl", ctrl);
	    Personaje p1=new Personaje();
	    p1.setId(Integer.parseInt(request.getParameter("id1")));
	    session.setAttribute("per1",ctrl.Buscar(p1));
	    
	    p1.setId(Integer.parseInt(request.getParameter("id2")));
	    session.setAttribute("per2",ctrl.Buscar(p1));
	    
	    session.setAttribute("gano", false);
	    session.setAttribute("evadio", false);
	    
	    ((ControladorJuego)session.getAttribute("ctrl")).Seleccionar((Personaje)session.getAttribute("per1"), (Personaje)session.getAttribute("per2"));
	    request.getRequestDispatcher("Combate.jsp").forward(request, response);
	    
	    
	}

}
