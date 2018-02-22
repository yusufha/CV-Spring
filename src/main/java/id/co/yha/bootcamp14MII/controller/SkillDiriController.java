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
import id.co.yha.bootcamp14MII.dao.SkillDAO;
import id.co.yha.bootcamp14MII.dao.SkillDiriDAO;
import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Skilldiri;

@Controller
@RequestMapping("sd")
public class SkillDiriController {
	
	@Autowired
	private SkillDiriDAO skilldiriDAO;

	@Autowired
	private SkillDAO skillDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaSD", skilldiriDAO.getAllSD());
		
		return "sd/index";
	}
	
	@GetMapping("/detail/{skilldiriPK}")
	public String detail(Model model, @PathVariable("skilldiriPK") int id) {
		model.addAttribute("objekSD", skilldiriDAO.getSkilldiri(id));
		return "sd/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("skilldiri", new Skilldiri());
		model.addAttribute("getSkill", skillDAO.getAllSkill());
		return "sd/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Skilldiri sd, BindingResult result) {
		
		if(!result.hasErrors() && skilldiriDAO.addSkilldiri(sd)) {
			return "redirect:/sd/index";
		}
		else {
			return "sd/add";
		}
	}
	
	@GetMapping("/edit/{skilldiriPK}")
	public String editForm(Model model, @PathVariable("skilldiriPK") int id) {
		model.addAttribute("skilldiri", skilldiriDAO.getSkilldiri(id));
		return "sd/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid Skilldiri sd, BindingResult result) {
		if(!result.hasErrors() && skilldiriDAO.editSkilldiri(sd)) {
			return "redirect:/sd/index";
		}
		else {
			return "sd/edit/";
		}
	}
}
