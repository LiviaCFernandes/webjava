package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DtoUsuarioEndereco;
import entity.Endereco;
import entity.Usuario;
import persistence.UsuarioDao;


@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("gravar")) {
			gravar(request, response);
		}
	}

	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
			u.setNome(request.getParameter("nome"));
			u.setEmail(request.getParameter("email"));
		Endereco e = new Endereco();
			e.setLogradouro(request.getParameter("logradouro"));
			e.setBairro(request.getParameter("bairro"));
			e.setCidade(request.getParameter("cidade"));
			e.setEstado(request.getParameter("estado"));
			e.setCep(request.getParameter("cep"));
		try {
			UsuarioDao dao = new UsuarioDao();
			dao.create(u, e);
			List<DtoUsuarioEndereco> lista = dao.findAllDTO();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("consulta.jsp").forward(request, response);
		}catch(Exception ex) {
			request.setAttribute("error", ex.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}
	
}
