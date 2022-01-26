package gestionCinema.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gestionCinema.bll.ClientManager;
import gestionCinema.bo.Client;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientManager clientManager;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("lstClient", clientManager.selectAll());
		model.addAttribute("client", new Client());
		return "client";

	}

	@PostMapping("/add")
	public String add(Model model, Client client) throws Exception {
		clientManager.insert(client);
		return "redirect:/client";
	}
}
