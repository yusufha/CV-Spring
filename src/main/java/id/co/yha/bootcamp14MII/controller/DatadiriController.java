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

import id.co.yha.bootcamp14MII.dao.DatadiriDAO;
import id.co.yha.bootcamp14MII.model.Datadiri;

@Controller
@RequestMapping("datadiri")
public class DatadiriController {

	@Autowired
	private DatadiriDAO datadiriDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaDatadiri", datadiriDAO.getAllDatadiri());
		return "datadiri/index";
	}
	
	@GetMapping("/detail/{datadiriId}")
	public String detail(Model model, @PathVariable("datadiriId") int id) {
		model.addAttribute("objekDatadiri", datadiriDAO.getDatadiri(id));
		return "datadiri/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("datadiri", new Datadiri());
		return "datadiri/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Datadiri datadiri, BindingResult result) {
		if(!result.hasErrors() && datadiriDAO.addDatadiri(datadiri)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "datadiri/add";
		}
	}
	
	@GetMapping("/edit/{datadiriId}")
	public String editForm(Model model, @PathVariable("datadiriId") int id) {
		model.addAttribute("datadiri", datadiriDAO.getDatadiri(id));
		return "datadiri/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid Datadiri datadiri, BindingResult result) {
		if(!result.hasErrors() && datadiriDAO.editDatadiri(datadiri)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "datadiri/edit/";
		}
	}
	
}
