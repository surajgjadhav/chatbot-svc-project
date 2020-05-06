package com.chatbot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.test.exception.RecordNotFoundException;
import com.chatbot.test.exception.RecordNotSavedException;
import com.chatbot.test.service.impl.UserMgmtServiceImpl;
import com.chatbot.test.vo.ResponseVO;

@RestController
public class chatBotMgmtController {
	
	@Autowired
	UserMgmtServiceImpl userMgmtServiceImpl;
	
	/**
	 * This is the put request to update User address having given Upload ID
	 * @param userId
	 * @param address
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/address/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseVO> updateAddress(@PathVariable("userId") final int userId,@RequestParam("Address") final String address) throws RecordNotFoundException {
		final ResponseVO response = userMgmtServiceImpl.updateUserAddressById(userId, address);
		return new ResponseEntity<ResponseVO>(response,HttpStatus.OK);
	}
	
	/**
	 * This is the put request to update User email having given Upload ID
	 * @param userId
	 * @param email
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/email/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseVO> updateEmail(@PathVariable("userId") final int userId,@RequestParam("Email") final String email) throws RecordNotFoundException {
		final ResponseVO response = userMgmtServiceImpl.updateUserEmailById(userId, email);
		return new ResponseEntity<ResponseVO>(response,HttpStatus.OK);
	}
	
	/**
	 * This is the post method to save multiple users 
	 * @return
	 * @throws RecordNotSavedException 
	 *SSSS
	 */
	@RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
	public ResponseEntity<String> saveMultipleUsers() throws RecordNotSavedException {
		final String result = userMgmtServiceImpl.saveMultipleUsers();
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
