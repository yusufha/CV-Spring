package id.co.yha.bootcamp14MII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.yha.bootcamp14MII.model.Akun;
import id.co.yha.bootcamp14MII.model.Datadiri;
import id.co.yha.bootcamp14MII.model.Organisasi;
import id.co.yha.bootcamp14MII.model.Pekerjaan;
import id.co.yha.bootcamp14MII.model.Pendidikan;
import id.co.yha.bootcamp14MII.model.Penghargaan;

@Service
public class DataDAO {
	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;

	public Datadiri getDatadiri (int id) {
		return (Datadiri) factory.createEntityManager()
				.createQuery("from Akun where datadiriId =" +id )
				.getSingleResult();
	}
	
//	public Organisasi getOrganisasi (int id) {
//		return (Organisasi) factory.createEntityManager()
//				.createQuery("from Akun where organisasiId =" +id )
//				.getSingleResult();
//	}
//	
//	
//	public boolean addData(Data data) {
//		EntityManager eManager = factory.createEntityManager();
//		EntityTransaction transaksi = null;
//		boolean isSuccess = true;
//		
//		return isSuccess;
//	}

}
