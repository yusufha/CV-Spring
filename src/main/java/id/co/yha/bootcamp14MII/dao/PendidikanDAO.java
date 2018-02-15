package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.co.yha.bootcamp14MII.model.Pendidikan;

@Service
public class PendidikanDAO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Pendidikan> getAllPendidikan(){
		return factory.createEntityManager()
				.createQuery("from Pendidikan")
				.getResultList();
	}

	public Pendidikan getPendidikan(int id) {
		return (Pendidikan) factory.createEntityManager()
				.createQuery("from Pendidikan where datadiriId =" +id )
				.getSingleResult();
	}
	
	public boolean addPendidikan(Pendidikan pend) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(pend);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editPendidikan(Pendidikan updatedPend) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Pendidikan excistingPend = 
					(Pendidikan) eManager.find(Pendidikan.class, 
							updatedPend.getPendidikanId());
			excistingPend.setNamaSekolah(updatedPend.getNamaSekolah());
			excistingPend.setJurusan(updatedPend.getJurusan());
			excistingPend.setKota(updatedPend.getKota());
			excistingPend.setTahunMulai(updatedPend.getTahunMulai());
			excistingPend.setTahunSelesai(updatedPend.getTahunSelesai());
			excistingPend.setIpk(updatedPend.getIpk());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
}
