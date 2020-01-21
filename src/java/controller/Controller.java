package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Categoria;
import util.HibernateUtil;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Session singleton = HibernateUtil.getSessionFactory().openSession();
            HttpSession session = request.getSession();
            String op = request.getParameter("op");
            ArrayList<Categoria> categorias;
            RequestDispatcher dispatcher;
            if (op.equals("inicio")) {
                Query q = singleton.createQuery("from Categoria");  
                Iterator itc= q.iterate();
                categorias = new ArrayList<Categoria>();
                
                for (;itc.hasNext();){
                    Categoria categoria=(Categoria)itc.next();
                    categorias.add(categoria);
                }
                session.setAttribute("categorias", categorias);
                dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);

            } else if (op.equals("")) {
            }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
