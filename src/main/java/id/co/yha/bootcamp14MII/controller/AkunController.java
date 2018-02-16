package id.co.yha.bootcamp14MII.controller;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestMethod;

import id.co.yha.bootcamp14MII.dao.AkunDAO;
import id.co.yha.bootcamp14MII.model.Akun;

@Controller
@RequestMapping("akun")

public class AkunController {
	
	@Autowired
	private AkunDAO akunDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaAkun", akunDAO.getAllAkun());
		return "akun/index";
	}
	
	@GetMapping("/detail/{akunId}")
	public String detail(Model model, @PathVariable("akunId") int id) {
		model.addAttribute("objekAkun", akunDAO.getAkun(id));
		return "akun/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("aku", new Akun());
		return "akun/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Akun akun, BindingResult result) {
		if(!result.hasErrors() && akunDAO.addAkun(akun)) {
			return "redirect:/akun/index";
		}
		else {
			return "akun/add";
		}
	}
	
	@GetMapping("/edit/{akunId}")
	public String editForm(Model model, @PathVariable("akunId") int id) {
		model.addAttribute("akun", akunDAO.getAkun(id));
		return "akun/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid Akun akun, BindingResult result) {
		if(!result.hasErrors() && akunDAO.editAkun(akun)) {
			return "redirect:/akun/index";
		}
		else {
			return "akun/edit/";
		}
	}
	
	@DeleteMapping("/akun/{id}")
	   public ResponseEntity<?> delete(@PathVariable("akunId") int id) {
	      akunDAO.delete(id);
	      return ResponseEntity.ok().body("Akun has been deleted successfully.");
	}
	
//	@RequestMapping(value = "items/{id}", method = RequestMethod.DELETE)
//	public String delete(@PathVariable("akunId") int id) {
////	    Akun akun = akunDAO.getAkun(id);
//	    akunDAO.delete(id); 
//
//	    return "redirect:/akun/index";
//	}
	
//	@DeleteMapping("/hapus/{id}")
//	public ResponseEntity<Akun> deleteAkun(@PathVariable("akunId") int id) {
//	    if(akun == null) {
//	        return ResponseEntity.notFound().build();
//	    }
//	    akunDAO.delete(id);
//	    return ResponseEntity.ok().build();
//	}

}
