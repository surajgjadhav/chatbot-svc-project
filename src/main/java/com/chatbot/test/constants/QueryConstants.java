package com.chatbot.test.constants;

/**
 * This is the constant class for Query 
 * @author SURAJ
 *
 */
public class QueryConstants {

	
	public static final String GET_USERS = "from User";
	
	public static final String GET_USER_DETAILS_FROM_USERID = "from User u where u.userId =:userId ";
	
	public static final String GET_USER_DETAILS_FROM_EMAIL = "from User u where u.email =:email ";
	
	public static final String GET_USER_EMAIL = "select u.email from User u where u.userId =:userId";
	
	public static final String GET_USER_ADDRESS = "select u.address from User u where u.userId =:userId";
	
	public static final String UPDATE_USER_ADDRESS = "Update User u set u.address =: address where u.userId =:userId";
	
	public static final String UPDATE_USER_EMAIL = "Update User u set u.email =: email where u.userId =:userId";
}
