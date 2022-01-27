package gestionCinema.ihm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gestionCinema.bll.ClientManager;
import gestionCinema.bll.FilmManager;
import gestionCinema.bll.ReservationException;
import gestionCinema.bll.ReservationManager;
import gestionCinema.bll.SalleManager;
import gestionCinema.bll.SceanceManager;
import gestionCinema.bo.Film;
import gestionCinema.bo.Reservation;
import gestionCinema.bo.Sceance;

@Controller
public class GestionCinemaController {
	
	@Autowired
	SceanceManager manager;
	@Autowired
	FilmManager managerfilm;
	@Autowired 
	SalleManager managersalle;
	@Autowired 
	ReservationManager managerReserve;
	@Autowired
	ClientManager clientManager;
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
		try {
			manager.insert(sceance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:ASceance";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("sceance")Sceance sceance) {
		
		try {
			manager.update(sceance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:ASceance";
	}
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("lstSceancePlaceNP",manager.getSceanceWithRemainigSeats());
		return "home";
		
	}

	@GetMapping("/place")
	public String place(Model model) {
			

		model.addAttribute("lstSceance",manager.selectAll());	
		model.addAttribute("lstClient", clientManager.selectAll());
		model.addAttribute("lstSceancePlaceNP",manager.getSceanceWithRemainigSeats());
		model.addAttribute("reservation", new Reservation());
		return "placeDeCinema";
		
	}

	@PostMapping("/addR")
	public String addR(Model model, Reservation reservation) throws ReservationException {
		managerReserve.insert(reservation);
		return "redirect:/reservation";
	}

}
