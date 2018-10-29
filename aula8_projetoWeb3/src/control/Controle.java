package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import mail.EnviarEmail;
import persistence.UsuarioDao;

@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd.equalsIgnoreCase("gravar")) {
			gravar(request, response);
		}
	}
	
	protected void gravar(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Usuario u = new Usuario(null,nome, email);
		
		try {
			new UsuarioDao().create(u);
			new EnviarEmail().enviarEmail(u);
			request.setAttribute("msg", "Dados Gravados!");
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}catch(Exception ex) {
			request.setAttribute("msg", "Error: "+ex.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}


}
