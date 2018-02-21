package id.co.yha.bootcamp14MII.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.yha.bootcamp14MII.dao.SkillDAO;
import id.co.yha.bootcamp14MII.model.Skill;


@Controller
@RequestMapping("skill")
public class SkillController {
	
	@Autowired
	private SkillDAO skillDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaSkill", skillDAO.getAllSkill());
		return "skill/index";
	}
	
	@GetMapping("/detail/{skillId}")
	public String detail(Model model, @PathVariable("skillId") int id) {
		model.addAttribute("objekSkill", skillDAO.getSkill(id));
		return "skill/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("skill", new Skill());
		return "skill/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Skill skill, BindingResult result) {
		if(!result.hasErrors() && skillDAO.addSkill(skill)) {
			return "redirect:/skill/index";
		}
		else {
			return "skill/add";
		}
	}
	
	@GetMapping("/edit/{skillId}")
	public String editForm(Model model, @PathVariable("skillId") int id) {
		model.addAttribute("skill", skillDAO.getSkill(id));
		return "skill/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid Skill skill, BindingResult result) {
		if(!result.hasErrors() && skillDAO.editSkill(skill)) {
			return "redirect:/skill/index";
		}
		else {
			return "skill/edit";
		}
	}
	
	@DeleteMapping("/skill/{id}")
	   public ResponseEntity<?> delete(@PathVariable("skillId") int id) {
	      //skillDAO.delete(id);
	      return ResponseEntity.ok().body("Akun has been deleted successfully.");
	}

}
