package com.chatbot.test.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.chatbot.test.model.User;

/**
 * This is the class for Session Factory
 * @author SURAJ
 *
 */
@Component
public class HibernateSessionFactory {

	/**
	 * This method is used to get Session Factory
	 * @return
	 */
    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
        
        SessionFactory sessionFactory = config.buildSessionFactory();
        
        return sessionFactory;
    }

}
