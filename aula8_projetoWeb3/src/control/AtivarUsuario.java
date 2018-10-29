package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import persistence.UsuarioDao;

@WebServlet("/AtivarUsuario")
public class AtivarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Usuario u = new Usuario(null,null,email);
		
		try {
			new UsuarioDao().ativa(u); //aq q muda o status do ativo  ~update
			request.setAttribute("msg", "Usuario ativo!");
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}catch(Exception ex) {
			request.setAttribute("msg", "Error: "+ex.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
