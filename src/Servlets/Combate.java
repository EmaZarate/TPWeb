package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Controlador.ControladorJuego;
import Entidades.Personaje;

import org.apache.catalina.Session;
import org.apache.catalina.util.SessionIdGenerator;
import org.omg.CORBA.portable.ApplicationException;

import Controlador.ControladorJuego;

/**
 * Servlet implementation class JugarServlet
 */
@WebServlet("/Combate")
public class Combate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Combate() {
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
		 HttpSession session = request.getSession(false);
		 String accion =request.getParameter("accion");
		 ControladorJuego ctrl=(ControladorJuego)session.getAttribute("ctrl");
		 
		if(accion.equals("atacar")){
			   try {
				int energia= Integer.parseInt(request.getParameter("energia"));
				if(ctrl.Atacar(energia)){
					session.setAttribute("evadio", true);
					ctrl.Turno();
				}
				else{	
					session.setAttribute("evadio", false);
				    if(ctrl.getVidaJugadorAtacado()<=0){
					   session.setAttribute("gano", true);
					   ctrl.updateGanador();
					   session.setAttribute("per1", ctrl.Buscar((Personaje)session.getAttribute("per1")));
					   session.setAttribute("per2", ctrl.Buscar((Personaje)session.getAttribute("per2")));
				    }
				    else
				    {
				     ctrl.Turno();
				    }
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else{
			ctrl.Defender();
			ctrl.Turno();
		}
		
		request.getRequestDispatcher("Combate.jsp").forward(request, response);
	}

}
