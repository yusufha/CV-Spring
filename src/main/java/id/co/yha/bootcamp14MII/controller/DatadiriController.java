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
import id.co.yha.bootcamp14MII.dao.OrganisasiDAO;
import id.co.yha.bootcamp14MII.dao.PekerjaanDAO;
import id.co.yha.bootcamp14MII.dao.PendidikanDAO;
import id.co.yha.bootcamp14MII.dao.PenghargaanDAO;
import id.co.yha.bootcamp14MII.dao.SkillDAO;
import id.co.yha.bootcamp14MII.dao.SkillDiriDAO;
import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Organisasi;
import id.co.yha.bootcamp14MII.model.Pekerjaan;
import id.co.yha.bootcamp14MII.model.Pendidikan;
import id.co.yha.bootcamp14MII.model.Penghargaan;
import id.co.yha.bootcamp14MII.model.Skill;
import id.co.yha.bootcamp14MII.model.Skilldiri;

@Controller
@RequestMapping("datadiri")
public class DatadiriController {

	@Autowired
	private DatadiriDAO datadiriDAO;
	@Autowired
	private PendidikanDAO pendidikanDAO;
	@Autowired
	private PekerjaanDAO pekerjaanDAO;
	@Autowired
	private OrganisasiDAO organisasiDAO;
	@Autowired
	private PenghargaanDAO penghargaanDAO;
	@Autowired
	private SkillDAO skillDAO;
	@Autowired
	private SkillDiriDAO skilldiriDAO;
	 
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaDatadiri", datadiriDAO.getAllDatadiri());
		return "datadiri/index";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") int id) {
		model.addAttribute("objekDatadiri", datadiriDAO.getDatadiri(id));
		return "datadiri/detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("datadiri", new Datadiri());
		model.addAttribute("getSkill", skillDAO.getAllSkill());
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
	
	@GetMapping("/edit/{id}")
	public String editForm(Model model, @PathVariable("id") int id) {
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
	
	/**
	 * Pendidikan
	 */
	@GetMapping("/addPendidikan")
	public String addPendidikan(Model model) {
		model.addAttribute("pendidikan", new Pendidikan());
		return "pendidikan/add";
	}
	
	@PostMapping("/addPendidikan")
	public String addPendidikan(@Valid Pendidikan pendidikan, BindingResult result) {
		if(!result.hasErrors() && pendidikanDAO.addPendidikan(pendidikan)) {
			return "redirect:/pendidikan/index";
		}
		else {
			return "pendidikan/add";
		}
	}
	
	@GetMapping("/editPendidikan/{pendidikanId}")
	public String editFormPendidikan(Model model, @PathVariable("pendidikanId") int id) {
		model.addAttribute("pendidikan", pendidikanDAO.getPendidikan(id));
		return "pendidikan/edit";
	}
	
	@PostMapping("/editPendidikan")
	public String editPendidikan(@Valid Pendidikan pendidikan, BindingResult result) {
		if(!result.hasErrors() && pendidikanDAO.editPendidikan(pendidikan)) {
			return "redirect:/pendidikan/index";
		}
		else {
			return "pendidikan/edit/";
		}
	}
	
	/**
	 * Pekerjaan
	 */
	@GetMapping("/addPekerjaan/{datadiriId}")
	public String addPekerjaan(Model model, @PathVariable("datadiriId") int id) {
		model.addAttribute("pekerjaan", new Pekerjaan());
		return "pekerjaan/add";
	}
	
	@PostMapping("/addPekerjaan")
	public String addPekerjaan(@Valid Pekerjaan pekerjaan, BindingResult result) {
		if(!result.hasErrors() && pekerjaanDAO.addPekerjaan(pekerjaan)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "pekerjaan/add";
		}
	}
	
	@GetMapping("/editPekerjaan/{pekerjaanId}")
	public String editFormPekerjaan(Model model, @PathVariable("pekerjaanId") int id) {
		model.addAttribute("pekerjaan", pekerjaanDAO.getPekerjaan(id));
		return "pekerjaan/edit";
	}
	
	@PostMapping("/editPekerjaan")
	public String editPekerjaan(@Valid Pekerjaan pekerjaan, BindingResult result) {
		if(!result.hasErrors() && pekerjaanDAO.editPekerjaan(pekerjaan)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "pekerjaan/edit/";
		}
	}
	
	/**
	 * Organisasi
	 */
	@GetMapping("/addOrganisasi")
	public String addOrganisasi(Model model) {
		model.addAttribute("organisasi", new Organisasi());
		return "organisasi/add";
	}
	
	@PostMapping("/addOrganisasi")
	public String addOrganisasi(@Valid Organisasi organisasi, BindingResult result) {
		if(!result.hasErrors() && organisasiDAO.addOrganisasi(organisasi)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "organisasi/add";
		}
	}
	
	@GetMapping("/editOrganisasi/{organisasiId}")
	public String editFormOrganisasi(Model model, @PathVariable("organisasiId") int id) {
		model.addAttribute("organisasi", organisasiDAO.getOrganisasi(id));
		return "organisasi/edit";
	}
	
	@PostMapping("/editOrganisasi")
	public String editOrganisasi(@Valid Organisasi org, BindingResult result) {
		if(!result.hasErrors() && organisasiDAO.editOrganisasi(org)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "organisasi/edit/";
		}
	}
	
	/**
	 * Penghargaan
	 */
	@GetMapping("/addPenghargaan")
	public String addPenghargaan(Model model) {
		model.addAttribute("penghargaan", new Penghargaan());
		return "penghargaan/add";
	}
	
	@PostMapping("/addPenghargaan")
	public String addPenghargaan(@Valid Penghargaan penghargaan, BindingResult result) {
		if(!result.hasErrors() && penghargaanDAO.addPenghargaan(penghargaan)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "penghargaan/add";
		}
	}
	
	@GetMapping("/editPenghargaan/{penghargaanId}")
	public String editFormPenghargaan(Model model, @PathVariable("penghargaanId") int id) {
		model.addAttribute("penghargaan", penghargaanDAO.getPenghargaan(id));
		return "penghargaan/edit";
	}
	
	@PostMapping("/editPenghargaan")
	public String editPenghargaan(@Valid Penghargaan penghargaan, BindingResult result) {
		if(!result.hasErrors() && penghargaanDAO.editPenghargaan(penghargaan)) {
			return "redirect:/datadiri/index";
		}
		else {
			return "penghargaan/edit/";
		}
	}
}
