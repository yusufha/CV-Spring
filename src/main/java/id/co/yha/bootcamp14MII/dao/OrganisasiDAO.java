package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.yha.bootcamp14MII.model.Organisasi;

@Service
public class OrganisasiDAO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Organisasi> getAllOrganisasi(){
		return factory.createEntityManager()
				.createQuery("from Organisasi")
				.getResultList();
	}

	public Organisasi getOrganisasi(int id) {
		return (Organisasi) factory.createEntityManager()
				.createQuery("from Organisasi where datadiriId =" +id )
				.getSingleResult();
	}
	
	public boolean addOrganisasi(Organisasi org) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			org.setIsActive(1);
			eManager.persist(org);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editOrganisasi(Organisasi updatedOrg) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Organisasi excistingOrg = 
					(Organisasi) eManager.find(Organisasi.class, 
							updatedOrg.getOrganisasiId());
			excistingOrg.setNamaOrganisasi(updatedOrg.getNamaOrganisasi());
			excistingOrg.setJabatan(updatedOrg.getJabatan());
			excistingOrg.setKota(updatedOrg.getKota());
			excistingOrg.setTahunMulai(updatedOrg.getTahunMulai());
			excistingOrg.setTahunSelesai(updatedOrg.getTahunSelesai());
			excistingOrg.setKeterangan(updatedOrg.getKeterangan());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

}
