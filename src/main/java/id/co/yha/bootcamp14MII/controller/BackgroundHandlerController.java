package id.co.yha.bootcamp14MII.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.yha.bootcamp14MII.dao.AkunDAO;
import id.co.yha.bootcamp14MII.dao.DatadiriDAO;
import id.co.yha.bootcamp14MII.dao.SkillDAO;
import id.co.yha.bootcamp14MII.dao.SkillDiriDAO;
import id.co.yha.bootcamp14MII.model.Akun;
import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Skill;
import id.co.yha.bootcamp14MII.model.Skilldiri;
import id.co.yha.bootcamp14MII.model.SkilldiriPK;

@RestController
public class BackgroundHandlerController {
	
	@Autowired
	private EntityManagerFactory factory;
	
	@Autowired 
	private DatadiriDAO datadiriDAO;
	
	@Autowired
	private AkunDAO akunDAO;
	
	@Autowired
	private SkillDAO skillDAO;
	
	@Autowired
	private SkillDiriDAO skillDiriDAO;
	
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
	
	@GetMapping("/skillName")
	public List<String> getAllSkillName(){
		StringBuilder builder;
		List<String> hasil = new ArrayList<>();
		List<Skill> listSkill = factory.createEntityManager().createQuery("from Skill where isActive=1")
				.getResultList();
		
		for (Skill skill : listSkill) {
			builder = new StringBuilder();
			builder.append(skill.getNamaSkill());
			hasil.add(builder.toString());
		}
		
		return hasil;
	}
	
	@GetMapping("/skillId")
	public List<String> getAllSkillId(){
		StringBuilder builder;
		List<String> hasil = new ArrayList<>();
		List<Skill> listSkill = factory.createEntityManager().createQuery("from Skill where isActive=1")
				.getResultList();
		
		for (Skill skill : listSkill) {
			builder = new StringBuilder();
			builder.append(skill.getSkillId());
			hasil.add(builder.toString());
		}
		
		return hasil;
	}
	
	@GetMapping("/addSkill")
	public boolean acSkill(@RequestParam("id") int id, 
			@RequestParam("skillId") int idSkill) {
		Skilldiri sd = new Skilldiri();
		sd.setSkilldiriPK(new SkilldiriPK());
		sd.getSkilldiriPK().setId(id);
		sd.getSkilldiriPK().setSkillId(idSkill);
		return skillDiriDAO.addSkilldiri(sd);
	}

}
