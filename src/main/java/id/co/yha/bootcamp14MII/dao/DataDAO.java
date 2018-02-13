package id.co.yha.bootcamp14MII.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataDAO {
	private static final Logger log = 
			LoggerFactory.getLogger(AkunDAO.class);
	
	@Autowired
	private EntityManagerFactory factory;
	
	@Autowired
	private SessionFactory sessionFactory;

}
