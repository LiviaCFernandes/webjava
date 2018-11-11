package control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Usuario;
import persistence.UsuarioDao;

@Controller
public class ControllerUsuario {

	@RequestMapping(value = "/", method = RequestMethod.GET) // a '/' é entrada de dados
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg", "Bem-vindo a Pagina Principal");
		return mv;
	}

	@RequestMapping(value="/gravar.html", method=RequestMethod.POST)
	public ModelAndView gravar(Usuario usuario) {
		ModelAndView mv = new ModelAndView ("login");
		try {
			new UsuarioDao().create(usuario);
			mv.addObject("msg","Dados do usuário gravados!");
		}catch(Exception ex) {
			mv.addObject ("msg", "Error: "+ ex.getMessage());
		}
		return mv;
	}
	
	@RequestMapping(value = "/logar.html", method = RequestMethod.POST)
	public ModelAndView logar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("login");
		try {
			UsuarioDao dao = new UsuarioDao();
			Usuario usu = dao.findByLogin(usuario);
			
			List<Usuario> lst = new ArrayList<Usuario>();

			if (usu == null) {
				mv.addObject("msg", "Login inválido!");
				return mv;
			} else {
				ModelAndView mv2 = new ModelAndView("logado");
				
				List<Usuario> usuarios = new ArrayList<Usuario>();
					usuarios = new UsuarioDao().findAll();
				
				mv2.addObject("usuario", usu);
				mv2.addObject("usuarios", usuarios);
					
				return mv2;
			}
		}catch (Exception ex) {
			mv.addObject("msg", "Error: " + ex.getMessage());
			return mv;
		}
	}
}
