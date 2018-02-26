package id.co.yha.bootcamp14MII;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import id.co.yha.bootcamp14MII.model.Akun;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().defaultSuccessUrl("/datadiri/index", true)
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	List<Akun> listUser = entityManagerFactory
				.createEntityManager()
				.createQuery("from Akun where isActive = 1")
				.getResultList();
		for (Akun user : listUser) {
			auth.inMemoryAuthentication().withUser(user.getUsername()).password(user.getPw()).roles("USER")
			.and().withUser("admin").password("admin").roles("ADMIN");
		}
    }
}
