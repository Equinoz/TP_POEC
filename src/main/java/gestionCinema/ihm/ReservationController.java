package gestionCinema.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gestionCinema.bll.ClientManager;
import gestionCinema.bll.ReservationException;
import gestionCinema.bll.ReservationManager;
import gestionCinema.bll.SceanceManager;
import gestionCinema.bo.Reservation;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ClientManager clientManager;

	@Autowired
	SceanceManager sceanceManager;

	@Autowired
	ReservationManager reservationManager;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("lstSceance", sceanceManager.selectAll());
		model.addAttribute("lstClient", clientManager.selectAll());
		model.addAttribute("reservation", new Reservation());
		return "reservation";

	}

	@PostMapping("/add")
	public String add(Model model, Reservation reservation) throws ReservationException {
		reservationManager.insert(reservation);
		return "redirect:/reservation";
	}

}
