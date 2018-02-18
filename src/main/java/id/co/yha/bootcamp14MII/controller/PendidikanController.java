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

import id.co.yha.bootcamp14MII.dao.PendidikanDAO;
import id.co.yha.bootcamp14MII.model.Pendidikan;


@Controller
@RequestMapping("pendidikan")

public class PendidikanController {
	
	@Autowired
	private PendidikanDAO pendidikanDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaPendidikan", pendidikanDAO.getAllPendidikan());
		return "pendidikan/index";
	}
	
	@GetMapping("/detail/{pendidikanId}")
	public String detail(Model model, @PathVariable("pendidikanId") int id) {
		model.addAttribute("objPendidikan", pendidikanDAO.getPendidikan(id));
		return "pendidikan/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("pendidikan", new Pendidikan());
		return "pendidikan/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Pendidikan pendidikan, BindingResult result) {
		if(!result.hasErrors() && pendidikanDAO.addPendidikan(pendidikan)) {
			return "redirect:/pendidikan/index";
		}
		else {
			return "pendidikan/add";
		}
	}
	
	@GetMapping("/edit/{pendidikanId}")
	public String editForm(Model model, @PathVariable("pendidikanId") int id) {
		model.addAttribute("pendidikan", pendidikanDAO.getPendidikan(id));
		return "pendidikan/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid Pendidikan pendidikan, BindingResult result) {
		if(!result.hasErrors() && pendidikanDAO.editPendidikan(pendidikan)) {
			return "redirect:/pendidikan/index";
		}
		else {
			return "pendidikan/edit/";
		}
	}

}
