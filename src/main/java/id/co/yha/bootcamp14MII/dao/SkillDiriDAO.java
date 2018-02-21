package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Skilldiri;


@Service
public class SkillDiriDAO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(SkillDAO.class);

	@Autowired
	private EntityManagerFactory factory;
	
	public List<Skilldiri> getAllSD(){
		return factory.createEntityManager()
				.createQuery("from Skilldiri")
				.getResultList();
	}

	public Skilldiri getSkilldiri(int id) {
		return (Skilldiri) factory.createEntityManager()
				.createQuery("from Skilldiri where datadiriId =" +id )
				.getSingleResult();
	}
	
	public boolean addSkilldiri(Skilldiri sd, Datadiri dd) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			dd.setDatadiriId(19);
			eManager.merge(dd);
			transaksi = eManager.getTransaction();
			transaksi.begin();
			sd.setIsActive(1);
			eManager.persist(sd);
			transaksi.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editSkilldiri(Skilldiri updatedSD) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Skilldiri excistingSD = 
					(Skilldiri) eManager.find(Skilldiri.class, 
							updatedSD.getSkilldiriPK());
			excistingSD.setDatadiri(updatedSD.getDatadiri());
			excistingSD.setSkill(updatedSD.getSkill());
			excistingSD.setNama(updatedSD.getNama());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

}
