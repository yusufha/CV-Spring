package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.co.yha.bootcamp14MII.model.Pekerjaan;

@Service
public class PekerjaanDAO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Pekerjaan> getAllPekerjaan(){
		return factory.createEntityManager()
				.createQuery("from Organisasi")
				.getResultList();
	}

	public Pekerjaan getPekerjaan(int id) {
		return (Pekerjaan) factory.createEntityManager()
				.createQuery("from Pekerjaan where datadiriId =" +id )
				.getSingleResult();
	}
	
	public boolean addPekerjaan(Pekerjaan kerja) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(kerja);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editPekerjaan(Pekerjaan updatedKerja) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Pekerjaan excistingKerja = 
					(Pekerjaan) eManager.find(Pekerjaan.class, 
							updatedKerja.getPekerjaanId());
			excistingKerja.setNamaPerusahaan(updatedKerja.getNamaPerusahaan());
			excistingKerja.setJabatan(updatedKerja.getJabatan());
			excistingKerja.setKota(updatedKerja.getKota());
			excistingKerja.setTahunMulai(updatedKerja.getTahunMulai());
			excistingKerja.setTahunSelesai(updatedKerja.getTahunSelesai());
			excistingKerja.setKeterangan(updatedKerja.getKeterangan());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

}
