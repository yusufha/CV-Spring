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
import id.co.yha.bootcamp14MII.dao.SkillDiriPKDAO;
import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Organisasi;
import id.co.yha.bootcamp14MII.model.Pekerjaan;
import id.co.yha.bootcamp14MII.model.Pendidikan;
import id.co.yha.bootcamp14MII.model.Penghargaan;
import id.co.yha.bootcamp14MII.model.Skill;
import id.co.yha.bootcamp14MII.model.Skilldiri;
import id.co.yha.bootcamp14MII.model.SkilldiriPK;

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
	@Autowired
	private SkillDiriPKDAO skilldiriPKDAO;
	 
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaDatadiri", datadiriDAO.getAllDatadiri());
		return "datadiri/index";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") int id) {
		model.addAttribute("objekDatadiri", datadiriDAO.getDatadiri(id));
		return "datadiri/details";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("datadiri", new Datadiri());
//		model.addAttribute("getSkill", skillDAO.getAllSkill());
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
	
//	/**
//	 * Pendidikan
//	 */
//	@GetMapping("/addPendidikan/{id}")
//	public String addPendidikan(Model model, @PathVariable("id") int id) {
//		Pendidikan pend = new Pendidikan();
//		pend.setId(datadiriDAO.getDatadiri(id));
//		model.addAttribute("pendidikan", pend);
//		return "pendidikan/add";
//	}
//	
//	@PostMapping("/addPendidikan")
//	public String addPendidikan(@Valid Pendidikan pendidikan, BindingResult result) {
//		if(!result.hasErrors() && pendidikanDAO.addPendidikan(pendidikan)) {
//			return "redirect:/pendidikan/index";
//		}
//		else {
//			return "pendidikan/add";
//		}
//	}
//	
//	@GetMapping("/editPendidikan/{pendidikanId}")
//	public String editFormPendidikan(Model model, @PathVariable("pendidikanId") int id) {
//		model.addAttribute("pendidikan", pendidikanDAO.getPendidikan(id));
//		return "pendidikan/edit";
//	}
//	
//	@PostMapping("/editPendidikan")
//	public String editPendidikan(@Valid Pendidikan pendidikan, BindingResult result) {
//		if(!result.hasErrors() && pendidikanDAO.editPendidikan(pendidikan)) {
//			return "redirect:/pendidikan/index";
//		}
//		else {
//			return "pendidikan/edit/";
//		}
//	}
//	
//	/**
//	 * Skill
//	 */
//	@GetMapping("/addSkill/{id}")
//	public String addSkill(Model model, @PathVariable("id") int id) {
//		Skilldiri sd = new Skilldiri();
//		sd.setSkilldiriPK(new SkilldiriPK());
//		sd.getSkilldiriPK().setId(id);
//		model.addAttribute("sd", sd);
//		//model.addAttribute("getSkill", skillDAO.getAllSkill());
//		return "sd/add";
//	}
//	
//	@PostMapping("/addSkill")
//	public String addSkill(@Valid Skilldiri skill, BindingResult result) {
//		if(!result.hasErrors() && skilldiriDAO.addSkilldiri(skill)) {
//			return "redirect:/datadiri/detail/{id}";
//		}
//		else {
//			return "sd/add";
//		}
//	}
////	
////	@GetMapping("/editSkill/{id}")
////	public String editFormSkill(Model model, @PathVariable("id") int id) {
////		model.addAttribute("skill", pendidikanDAO.getPendidikan(id));
////		return "pendidikan/edit";
////	}
////	
////	@PostMapping("/editSkill")
////	public String editSkill(@Valid SkilldiriPK sdpk, BindingResult result) {
////		if(!result.hasErrors() && skilldiriPKDAO.editPendidikan(pendidikan)) {
////			return "redirect:/pendidikan/index";
////		}
////		else {
////			return "pendidikan/edit/";
////		}
////	}
//	
//	/**
//	 * Pekerjaan
//	 */
//	@GetMapping("/addPekerjaan/{id}")
//	public String addPekerjaan(Model model, @PathVariable("id") int id) {
//		Pekerjaan kerja = new Pekerjaan();
//		kerja.setId(datadiriDAO.getDatadiri(id));
//		model.addAttribute("pekerjaan", kerja);
//		return "pekerjaan/add";
//	}
//	
//	@PostMapping("/addPekerjaan")
//	public String addPekerjaan(@Valid Pekerjaan pekerjaan, BindingResult result) {
//		if(!result.hasErrors() && pekerjaanDAO.addPekerjaan(pekerjaan)) {
//			return "redirect:/datadiri/index";
//		}
//		else {
//			return "pekerjaan/add";
//		}
//	}
//	
//	@GetMapping("/editPekerjaan/{pekerjaanId}")
//	public String editFormPekerjaan(Model model, @PathVariable("pekerjaanId") int id) {
//		model.addAttribute("pekerjaan", pekerjaanDAO.getPekerjaan(id));
//		return "pekerjaan/edit";
//	}
//	
//	@PostMapping("/editPekerjaan")
//	public String editPekerjaan(@Valid Pekerjaan pekerjaan, BindingResult result) {
//		if(!result.hasErrors() && pekerjaanDAO.editPekerjaan(pekerjaan)) {
//			return "redirect:/datadiri/index";
//		}
//		else {
//			return "pekerjaan/edit/";
//		}
//	}
//	
//	/**
//	 * Organisasi
//	 */
//	@GetMapping("/addOrganisasi/{id}")
//	public String addOrganisasi(Model model, @PathVariable("id") int id) {
//	Organisasi org = new Organisasi();
//	org.setId(datadiriDAO.getDatadiri(id));
//		model.addAttribute("organisasi", org);
//		return "organisasi/add";
//	}
//	
//	@PostMapping("/addOrganisasi")
//	public String addOrganisasi(@Valid Organisasi organisasi, BindingResult result) {
////		System.out.println("2 " + organisasi.getNamaOrganisasi());
////		organisasi.setId(datadiriDAO.getDatadiri(id));
//		if(!result.hasErrors() && organisasiDAO.addOrganisasi(organisasi)) {
//			return "redirect:/datadiri/index";
//		}
//		else {
//			return "organisasi/add";
//		}
//	}
//	
//	@GetMapping("/editOrganisasi/{organisasiId}")
//	public String editFormOrganisasi(Model model, @PathVariable("organisasiId") int id) {
//		model.addAttribute("organisasi", organisasiDAO.getOrganisasi(id));
//		return "organisasi/edit";
//	}
//	
//	@PostMapping("/editOrganisasi")
//	public String editOrganisasi(@Valid Organisasi org, BindingResult result) {
//		if(!result.hasErrors() && organisasiDAO.editOrganisasi(org)) {
//			return "redirect:/datadiri/index";
//		}
//		else {
//			return "organisasi/edit/";
//		}
//	}
//	
//	/**
//	 * Penghargaan
//	 */
//	@GetMapping("/addPenghargaan/{id}")
//	public String addPenghargaan(Model model, @PathVariable("id") int id) {
//		Penghargaan penghargaan = new Penghargaan();
//		penghargaan.setId(datadiriDAO.getDatadiri(id));
//		model.addAttribute("penghargaan", penghargaan);
//		return "penghargaan/add";
//	}
//	
//	@PostMapping("/addPenghargaan")
//	public String addPenghargaan(@Valid Penghargaan penghargaan, BindingResult result) {
//		if(!result.hasErrors() && penghargaanDAO.addPenghargaan(penghargaan)) {
//			return "redirect:/datadiri/index";
//		}
//		else {
//			return "penghargaan/add";
//		}
//	}
//	
//	@GetMapping("/editPenghargaan/{penghargaanId}")
//	public String editFormPenghargaan(Model model, @PathVariable("penghargaanId") int id) {
//		model.addAttribute("penghargaan", penghargaanDAO.getPenghargaan(id));
//		return "penghargaan/edit";
//	}
//	
//	@PostMapping("/editPenghargaan")
//	public String editPenghargaan(@Valid Penghargaan penghargaan, BindingResult result) {
//		if(!result.hasErrors() && penghargaanDAO.editPenghargaan(penghargaan)) {
//			return "redirect:/datadiri/index";
//		}
//		else {
//			return "penghargaan/edit/";
//		}
//	}
}
