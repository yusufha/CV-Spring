package id.co.yha.bootcamp14MII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import id.co.yha.bootcamp14MII.dao.DataDAO;

@Controller
@RequestMapping("data")
public class DataController {

	@Autowired
	private DataDAO dataDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		return "data/index";
	}
}
