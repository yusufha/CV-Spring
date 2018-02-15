package id.co.yha.bootcamp14MII.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CVController {

	@GetMapping("/welcome")
	public String index(Model model) {
		return "/welcome";
	}
}
