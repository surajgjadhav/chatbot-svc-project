package com.chatbot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.test.exception.RecordNotFoundException;
import com.chatbot.test.model.User;
import com.chatbot.test.service.impl.UserInfoServiceImpl;
import com.chatbot.test.vo.ResponseVO;

@RestController
public class chatBotInfoController {
	
	@Autowired
	UserInfoServiceImpl userInfoServiceImpl;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello() {
		return "hello!!!!";
	}
	
	/**
	 * This is the request to get email of user using userId
	 * @param userId
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/email/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO> getEmail(@PathVariable("userId") final int userId) throws RecordNotFoundException {
		final ResponseVO emailResponse = userInfoServiceImpl.getUserEmailById(userId);
		return new ResponseEntity<ResponseVO>(emailResponse,HttpStatus.FOUND);
	}
	
	/**
	 * This is the request to get address of user using userId
	 * @param userId
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/address/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getAddress(@PathVariable("userId") final int userId) throws RecordNotFoundException {
		final ResponseVO addressResponse = userInfoServiceImpl.getUserAddressById(userId);
		return new ResponseEntity<ResponseVO>(addressResponse,HttpStatus.FOUND);
	}
	
	/**
	 * This is the request to get details of user using userId
	 * @param userId
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/details/userId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getDetails(@PathVariable("userId") final int userId) throws RecordNotFoundException {
		final User user = userInfoServiceImpl.getUserDetailsById(userId);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	/**
	 * This is the request to get the details of user using email
	 * @param email
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/details/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> getDetails(@PathVariable("email") final String email) throws RecordNotFoundException {
		final User user = userInfoServiceImpl.getUserDetailsByEmail(email);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
}
