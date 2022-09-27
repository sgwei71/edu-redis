package com.ibkcloud.eduredis.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;	


@RestController
public class RestSampleController {
	
	private static final Logger log = LoggerFactory.getLogger(RestSampleController.class);
	
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	@GetMapping("/getSessionId")
	public String getSessionId(HttpSession session) {
		
		session.setAttribute("key1","abcde");
		log.debug(session.getId());
		return session.getId();
	}
	
	@GetMapping("/geValue")
	public String getValue(HttpSession session) {
		
		log.debug(session.getId());
		log.debug ((String)session.getAttribute("key1"));
		
		return (String)session.getAttribute("key1");
	}
}
