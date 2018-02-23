package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.yha.bootcamp14MII.model.Skilldiri;
import id.co.yha.bootcamp14MII.model.SkilldiriPK;

@Service
public class SkillDiriPKDAO {
	private static final Logger log = 
			LoggerFactory.getLogger(SkillDiriPKDAO.class);

	@Autowired
	private EntityManagerFactory factory;
	
	public List<SkilldiriPK> getAllSDPK(){
		return factory.createEntityManager()
				.createQuery("from SkilldiriPK")
				.getResultList();
	}

	public SkilldiriPK getSkilldiriPK(int id) {
		return (SkilldiriPK) factory.createEntityManager()
				.createQuery("from SkilldiriPK where id =" +id )
				.getSingleResult();
	}
	
	public boolean addSkilldiriPK(SkilldiriPK sdPK) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(sdPK);
			transaksi.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editSkilldiriPK(SkilldiriPK updatedSDPK) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			SkilldiriPK excistingSDPK = 
					(SkilldiriPK) eManager.find(SkilldiriPK.class, 
							updatedSDPK.getId());
			excistingSDPK.setSkillId(updatedSDPK.getSkillId());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

}
