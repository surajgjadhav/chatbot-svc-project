package com.chatbot.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.test.constants.ErrorMessages;
import com.chatbot.test.exception.RecordNotFoundException;
import com.chatbot.test.exception.RecordNotSavedException;
import com.chatbot.test.repo.impl.UserRepoImpl;
import com.chatbot.test.vo.ResponseVO;

/**
 * This is the Service class to save or update User Information
 * @author SURAJ
 *
 */
@Service
public class UserMgmtServiceImpl {

	@Autowired
	UserRepoImpl userRepoImpl;
	
	/**
	 * This method is used to update User address having given User ID
	 * @param userId
	 * @param address
	 * @return
	 * @throws RecordNotFoundException
	 */
	public ResponseVO updateUserAddressById(final int userId,final String address) throws RecordNotFoundException {
		final String result = userRepoImpl.updateUserAddress(userId, address);
		if (null != result) {
			final ResponseVO response = new ResponseVO();
			response.setMessage(result);
			return response;
		} else {
			throw new RecordNotFoundException(ErrorMessages.NO_RECORD_FOUND);
		}

	}
	
	/**
	 * This method is used to update User Email having given User ID 
	 * @param userId
	 * @param email
	 * @return
	 * @throws RecordNotFoundException
	 */
	public ResponseVO updateUserEmailById(final int userId,final String email) throws RecordNotFoundException {
		final String result = userRepoImpl.updateUserEmail(userId, email);
		if (null != result) {
			final ResponseVO response = new ResponseVO();
			response.setMessage(result);
			return response;
		} else {
			throw new RecordNotFoundException(ErrorMessages.NO_RECORD_FOUND);
		}

	}
	
	/**
	 * This method is used to save multiple Users
	 * @return
	 * @throws RecordNotSavedException
	 */
	public String saveMultipleUsers() throws RecordNotSavedException {
		final String result = userRepoImpl.saveUsers();
		if (null != result) {
			return result;
		} else {
			throw new RecordNotSavedException(ErrorMessages.RECORD_NOT_SAVED_SUCCESSFULLY);
		}

	}
}
