package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import persistence.UsuarioDao;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd.equalsIgnoreCase("gravar")) {
			gravar(request, response);
		} else if (cmd.equalsIgnoreCase("logar")) {
			logar(request, response);
		}
	}

	protected void gravar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setLogin(request.getParameter("login"));
		u.setSenha(request.getParameter("senha"));
		if (u.getLogin().equals("admin")) {
			u.setAcesso("max");
		} else {
			u.setAcesso("min");
		}

		try {
			UsuarioDao dao = new UsuarioDao();
			// grava id, login, senha e acesso
			dao.gravar(u);
			request.setAttribute("msg", "Dados Gravados!");
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("msg", "Error: " + ex.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}

	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setLogin(request.getParameter("login"));
		u.setSenha(request.getParameter("senha"));
		
		try {
			UsuarioDao dao = new UsuarioDao();
			Usuario resp = dao.logar(u);
			
			//se a resposta é diferente de vazio entao logou
			if(resp!=null) {
				request.setAttribute("msg", "Estou logado em "+resp.getLogin());
				//logou, voltou
				request.getRequestDispatcher("sistema.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Não logou!");
				request.getRequestDispatcher("sistema.jsp").forward(request, response);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("msg", "Error: " + ex.getMessage());
			//se deu erro, voltou
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}

}
