package id.co.yha.bootcamp14MII.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.co.yha.bootcamp14MII.model.Penghargaan;

@Service
public class PenghargaanDAO {
	

	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Penghargaan> getAllPenghargaan(){
		return factory.createEntityManager()
				.createQuery("from Penghargaan")
				.getResultList();
	}

	public Penghargaan getPenghargaan(int id) {
		return (Penghargaan) factory.createEntityManager()
				.createQuery("from Penghargaan where datadiriId =" +id )
				.getSingleResult();
	}
	
	public boolean addPenghargaan(Penghargaan penghargaan) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(penghargaan);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editPenghargaan(Penghargaan updatedPenghargaan) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Penghargaan excistingPenghargaan = 
					(Penghargaan) eManager.find(Penghargaan.class, 
							updatedPenghargaan.getPenghargaanId());
			excistingPenghargaan.setPenghargaan(updatedPenghargaan.getPenghargaan());
			excistingPenghargaan.setKeterangan(updatedPenghargaan.getKeterangan());
			excistingPenghargaan.setGambar(updatedPenghargaan.getGambar());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}


}
