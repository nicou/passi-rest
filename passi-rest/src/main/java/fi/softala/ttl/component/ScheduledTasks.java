/*
package fi.softala.ttl.component;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.model.AuthUser;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    
    @Inject
   	private PassiDAO dao;

   	public PassiDAO getDao() {
   		return dao;
   	}

   	public void setDao(PassiDAO dao) {
   		this.dao = dao;
   	}
    
    @Scheduled(fixedRate = (15 * 60 * 1000)) // 15 minutes
    public void loadAuthUsers() {
    	for (AuthUser authUser : dao.getAuthUsers()) {
    		if (!inMemoryUserDetailsManager.userExists(authUser.getUsername())) {
    			inMemoryUserDetailsManager.createUser(new User(authUser.getUsername(), authUser.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));
    		}
    	}
        log.info("Scheduled loading of new authorization users {}", dateFormat.format(new Date()));
    }
}
*/