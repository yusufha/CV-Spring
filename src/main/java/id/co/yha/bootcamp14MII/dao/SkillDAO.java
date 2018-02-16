package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.yha.bootcamp14MII.model.Skill;


@Service
public class SkillDAO {

	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Skill> getAllSkill(){
		return factory.createEntityManager()
				.createQuery("from Skill")
				.getResultList();
	}

	public Skill getSkill(int id) {
		return (Skill) factory.createEntityManager()
				.createQuery("from Skill where datadiriId =" +id )
				.getSingleResult();
	}
	
	public Skill getSkillData(int id) {
		return (Skill) factory.createEntityManager()
				.createQuery("from Skill where skillId =" +id )
				.getSingleResult();
	}
	
	public boolean addSkill(Skill skill) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(skill);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editSkill(Skill updatedSkill) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Skill excistingSkill = 
					(Skill) eManager.find(Skill.class, 
							updatedSkill.getSkillId());
			excistingSkill.setNamaSkill(updatedSkill.getNamaSkill());
			excistingSkill.setKeterangan(updatedSkill.getKeterangan());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

}
