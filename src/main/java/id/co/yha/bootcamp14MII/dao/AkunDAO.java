package id.co.yha.bootcamp14MII.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.co.yha.bootcamp14MII.model.Akun;


@Service
public class AkunDAO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	
	public List<Akun> getAllAkun(){
		return factory.createEntityManager()
				.createQuery("from Akun")
				.getResultList();
	}

	public Akun getAkun(int id) {
		return (Akun) factory.createEntityManager()
				.createQuery("from Akun where akunId =" +id )
				.getSingleResult();
	}
	
	public boolean addAkun(Akun akun) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(akun);
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			log.error("DAO Error", e.getMessage());
		}
		return isSuccess;
	}
	
	public boolean editAkun(Akun updatedAkun) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Akun excistingAkun = 
					(Akun) eManager.find(Akun.class, 
							updatedAkun.getAkunId());
			excistingAkun.setUsername(updatedAkun.getUsername());
			excistingAkun.setEmail(updatedAkun.getEmail());
			transaksi.commit();
		} catch(Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	
	public void delete(Akun akun){
		EntityManager eManager = factory.createEntityManager();

		eManager.getTransaction().begin();
	    eManager.remove(akun);
	    eManager.getTransaction().commit();
	}

}
