package id.co.yha.bootcamp14MII.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import id.co.yha.bootcamp14MII.dao.DataDAO;
import id.co.yha.bootcamp14MII.model.Datadiri;

@Controller
@RequestMapping("data")
public class DataController {

	@Autowired
	private DataDAO dataDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaDatadiri", dataDAO.getAllDatadiri());
		return "data/index";
	}
	
	@GetMapping("/detail/{akunId}")
	public String detail(Model model, @PathVariable("datadiriId") int id) {
		model.addAttribute("objekDatadiri", dataDAO.getDatadiri(id));
		return "data/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("data", new Datadiri());
		return "data/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Datadiri data, BindingResult result) {
		if(!result.hasErrors() && dataDAO.addDatadiri(data)) {
			return "redirect:/data/index";
		}
		else {
			return "data/add";
		}
	}
}
