package gestionCinema.ihm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gestionCinema.bll.FilmManager;
import gestionCinema.bll.SalleManager;
import gestionCinema.bll.SceanceManager;
import gestionCinema.bo.Film;
import gestionCinema.bo.Sceance;

@Controller
public class GestionCinemaController {
	
	@Autowired
	SceanceManager manager;
	@Autowired
	FilmManager managerfilm;
	@Autowired 
	SalleManager managersalle;
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
	@GetMapping("/ASceance")
	public String ASceance(Model model) {
		model.addAttribute("listDeFilm",managerfilm.selectAll());
		model.addAttribute("lstSalle",managersalle.selectAll());
		model.addAttribute("sceance",new Sceance());
		model.addAttribute("lstSceance",manager.selectAll());
		return "ASceance";
		
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("sceance")Sceance sceance) {
		
		manager.insert(sceance);
		
		return "redirect:ASceance";
	}
}
