package id.co.yha.bootcamp14MII;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CvSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvSpringApplication.class, args);
	}
	
//	@Bean  
//	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
//	    return hemf.getSessionFactory();  
//	}  
}
