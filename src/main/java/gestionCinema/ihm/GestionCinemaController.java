package gestionCinema.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import gestionCinema.bll.FilmManager;
import gestionCinema.bll.SceanceManager;
import gestionCinema.bo.Film;

@Controller
public class GestionCinemaController {
	
	@Autowired
	SceanceManager manager;
	@Autowired
	FilmManager managerfilm;
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("lstSceance",manager.selectAll());
		model.addAttribute("lstFilm",managerfilm.selectAll());
		return "index";
		
	}
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		Film film = managerfilm.selectById(id);
		model.addAttribute("film",film);
		return "show";
	}
	
	
}
