package id.co.yha.bootcamp14MII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.yha.bootcamp14MII.dao.AkunDAO;
import id.co.yha.bootcamp14MII.dao.DatadiriDAO;
import id.co.yha.bootcamp14MII.dao.SkillDAO;
import id.co.yha.bootcamp14MII.model.Akun;
import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Skill;

@RestController
public class BackgroundHandlerController {
	
	@Autowired 
	private DatadiriDAO datadiriDAO;
	
	@Autowired
	private AkunDAO akunDAO;
	
	@Autowired
	private SkillDAO skillDAO;
	
	@GetMapping("/deleteDatadiri")
	public boolean editDatadiri(@RequestParam("datadiriId") int id) {
		Datadiri dd = datadiriDAO.getDatadiri(id);
		dd.setIsActive(0);
		return datadiriDAO.editDatadiri(dd);
	}
	
	@GetMapping("/deleteAkun")
	public boolean editAkun(@RequestParam("akunId") int id) {
		Akun ak = akunDAO.getAkun(id);
		ak.setIsActive(0);
		return akunDAO.editAkun(ak);
	}
	
	@GetMapping("/deleteSkill")
	public boolean editSkill(@RequestParam("skillId") int id) {
		Skill sk = skillDAO.getSkill(id);
		sk.setIsActive(0);
		return skillDAO.editSkill(sk);
	}

}
