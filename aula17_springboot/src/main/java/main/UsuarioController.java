package main;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository dao;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("msg", "Site Login");
		return "index";
	}

	@PostMapping(value = "/usuario", 
				consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
				produces = MediaType.TEXT_PLAIN_VALUE)
	public ModelAndView salvar(@RequestParam String login, @RequestParam String senha, @RequestParam String foto) {
		ModelAndView mv = new ModelAndView("index");
		try {
			Usuario u = new Usuario(null, login, senha, foto);
			dao.save(u);
			mv.addObject("msg", "Dados gravados!");
		} catch (Exception ex) {
			mv.addObject("msg", "Error: " + ex.getMessage());
		}
		return mv;
	}

	@GetMapping(value="/listarservice",
			produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<Usuario> listaService() {
			try {
				return (List<Usuario>) dao.findAll();
			} catch (Exception ex) {
				return Collections.emptyList();
			}
		}
	
	@GetMapping(value="/listar",
			produces=MediaType.APPLICATION_JSON_VALUE)
		public ModelAndView listar() {
			ModelAndView mv = new ModelAndView("index");
			try {
				mv.addObject("lista", dao.findAll());
			} catch (Exception ex) {
				return mv.addObject("msg", "Error: "+ex.getMessage());
			}
			return mv;
		}

}
