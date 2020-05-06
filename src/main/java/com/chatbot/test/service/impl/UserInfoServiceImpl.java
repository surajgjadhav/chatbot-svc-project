package com.chatbot.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.test.constants.ErrorMessages;
import com.chatbot.test.exception.RecordNotFoundException;
import com.chatbot.test.model.User;
import com.chatbot.test.repo.impl.UserRepoImpl;
import com.chatbot.test.vo.ResponseVO;

/**
 * This is the service class for getting User Information
 * 
 * @author SURAJ
 *
 */
@Service
public class UserInfoServiceImpl {

	@Autowired
	UserRepoImpl userRepoImpl;

	/**
	 * This method is used get User Email having given User ID
	 * @param userId
	 * @return
	 * @throws RecordNotFoundException
	 */
	public ResponseVO getUserEmailById(final int userId) throws RecordNotFoundException {
		final String email = userRepoImpl.getUserEmail(userId);
		if (null != email) {
			final ResponseVO response = new ResponseVO();
			response.setMessage(email);
			return response;
		} else {
			throw new RecordNotFoundException(ErrorMessages.NO_RECORD_FOUND);
		}

	}
	
	/**
	 * This method is used to get User Address having given User ID
	 * @param userId
	 * @return
	 * @throws RecordNotFoundException
	 */
	public ResponseVO getUserAddressById(final int userId) throws RecordNotFoundException {
		final String address = userRepoImpl.getUserAddress(userId);
		if (null != address) {
			final ResponseVO response = new ResponseVO();
			response.setMessage(address);
			return response;
		} else {
			throw new RecordNotFoundException(ErrorMessages.NO_RECORD_FOUND);
		}

	}
	
	/**
	 * This method is used to get User Details having given User ID
	 * @param userId
	 * @return
	 * @throws RecordNotFoundException
	 */
	public User getUserDetailsById(final int userId) throws RecordNotFoundException {
		final User user = userRepoImpl.getUserDetailsFromUserId(userId);
		if (null != user) {
			return user;
		} else {
			throw new RecordNotFoundException(ErrorMessages.NO_RECORD_FOUND);
		}

	}
	
	/**
	 * This method is used to get User Details having given Email ID
	 * @param email
	 * @return
	 * @throws RecordNotFoundException
	 */
	public User getUserDetailsByEmail(final String email) throws RecordNotFoundException {
		final User user = userRepoImpl.getUserDetailsFromEmail(email);
		if (null != user) {
			return user;
		} else {
			throw new RecordNotFoundException(ErrorMessages.NO_RECORD_FOUND_FOR_GIVEN_EMAIL);
		}

	}
	
	
}
