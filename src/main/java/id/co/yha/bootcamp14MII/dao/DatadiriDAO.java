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


@Service
public class DatadiriDAO {

	private static final Logger log = 
			LoggerFactory.getLogger(DatadiriDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Datadiri> getAllDatadiri(){
		return factory.createEntityManager()
				.createQuery("from Datadiri where isActive = 1")
				.getResultList();
	}

	public Datadiri getDatadiri(int id) {
		return (Datadiri) factory.createEntityManager()
				.createQuery("from Datadiri where datadiriId =" +id )
				.getSingleResult();
	}
	
	public boolean addDatadiri(Datadiri datadiri) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			datadiri.setIsActive(1);
			eManager.persist(datadiri);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editDatadiri(Datadiri updatedDatadiri) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Datadiri excistingDatadiri = 
					(Datadiri) eManager.find(Datadiri.class, 
							updatedDatadiri.getDatadiriId());
			excistingDatadiri.setNamaLengkap(updatedDatadiri.getNamaLengkap());
			excistingDatadiri.setUmur(updatedDatadiri.getUmur());
			excistingDatadiri.setTempatLahir(updatedDatadiri.getTempatLahir());
			excistingDatadiri.setTanggalLahir(updatedDatadiri.getTanggalLahir());
			excistingDatadiri.setGender(updatedDatadiri.getGender());
			excistingDatadiri.setAgama(updatedDatadiri.getAgama());
			excistingDatadiri.setKewarganegaraan(updatedDatadiri.getKewarganegaraan());
			excistingDatadiri.setStatusPerkawinan(updatedDatadiri.getStatusPerkawinan());
			excistingDatadiri.setTinggi(updatedDatadiri.getTinggi());
			excistingDatadiri.setBerat(updatedDatadiri.getBerat());
			excistingDatadiri.setAlamat(updatedDatadiri.getAlamat());
			excistingDatadiri.setFoto(updatedDatadiri.getFoto());
			excistingDatadiri.setProfilSingkat(updatedDatadiri.getProfilSingkat());
			excistingDatadiri.setIsActive(updatedDatadiri.getIsActive());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean deleteDatadiri(Datadiri dd) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Datadiri exisDD = (Datadiri) eManager.find(Datadiri.class, dd.getDatadiriId());
			exisDD.setIsActive(dd.getIsActive());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

}
