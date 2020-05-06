package com.chatbot.test.repo.impl;


import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatbot.test.config.HibernateSessionFactory;
import com.chatbot.test.constants.QueryConstants;
import com.chatbot.test.model.User;

/**
 * This is the DAO for User Table
 * 
 * @author SURAJ
 *
 */
@Repository
public class UserRepoImpl {

	@Autowired
	HibernateSessionFactory sessionFactory;

	/**
	 * This method is used to get User Email having given User ID
	 * 
	 * @param userId
	 * @return
	 */
	public String getUserEmail(final int userId) {
		String email = null;
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			Query query = session.createQuery(QueryConstants.GET_USER_EMAIL);
			query.setParameter("userId", userId);
			email = (String) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;

	}

	/**
	 * This method is used to get User address having given User ID
	 * 
	 * @param userId
	 * @return
	 */
	public String getUserAddress(final int userId) {
		String address = null;
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			Query query = session.createQuery(QueryConstants.GET_USER_ADDRESS);
			query.setParameter("userId", userId);
			address = (String) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;

	}
	
	/**
	 * This method is used to get User Details using User ID
	 * @param userId
	 * @return
	 */
	public User getUserDetailsFromUserId(final int userId) {
		User user = null;
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			Query query = session.createQuery(QueryConstants.GET_USER_DETAILS_FROM_USERID);
			query.setParameter("userId", userId);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
	
	/**
	 * This method is used to get User Details using Email ID
	 * @param email
	 * @return
	 */
	public User getUserDetailsFromEmail(final String email) {
		User user = null;
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			Query query = session.createQuery(QueryConstants.GET_USER_DETAILS_FROM_EMAIL);
			query.setParameter("email", email);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	/**
	 * This method is used to update User Address having given User ID
	 * 
	 * @param userId
	 * @param address
	 * @return
	 */
	public String updateUserAddress(final int userId, final String address) {
		String result = "succeess";
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(QueryConstants.UPDATE_USER_ADDRESS);
			query.setParameter("userId", userId);
			query.setParameter("address", address);
			final int output = query.executeUpdate();
			transaction.commit();
			result = output > 0 ? "successful" : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * This method is used to update User Email having given User ID
	 * 
	 * @param userId
	 * @param email
	 * @return
	 */
	public String updateUserEmail(final int userId, final String email) {
		String result = null;
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(QueryConstants.UPDATE_USER_EMAIL);
			query.setParameter("userId", userId);
			query.setParameter("email", email);
			final int output = query.executeUpdate();
			transaction.commit();
			result = output > 0 ? "successful" : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	/**
	 * This method is used to save multiple users in table 
	 * @return
	 */
	public String saveUsers() {
		User user1 = new User("suraj", "satara", "suraj@gmail.com",Date.valueOf("1999-03-08"));
		User user2 = new User("suresh", "sangli", "suresh@gmail.com",Date.valueOf("1970-4-8"));
		User user3 = new User("ramesh","karad","ramesh@gmail.com",Date.valueOf("1980-5-9"));
		User user4 = new User("steve","america","steve@gmail.com",Date.valueOf("1955-2-24"));
		
		Transaction transaction = null;
		String result = null;
		try (Session session = sessionFactory.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// save the user objects
			session.saveOrUpdate(user1);
			session.saveOrUpdate(user2);
			session.saveOrUpdate(user3);
			session.saveOrUpdate(user4);

			// commit transaction
			transaction.commit();
			
			result = "saved";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
