package id.co.yha.bootcamp14MII.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/datadiri/index";
        }
        return "redirect:/user/index";
    }
	
//	@GetMapping("/login")
//	  public String printWelcome(Model model, Principal principal ) {
//
//	      String name = principal.getName(); //get logged in username
//	      model.addAttribute("username", name);
//	      return "hello";
//
//	  }
}
