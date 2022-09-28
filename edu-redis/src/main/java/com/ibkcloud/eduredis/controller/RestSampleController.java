package com.ibkcloud.eduredis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSampleController {

	private static final Logger log = LoggerFactory.getLogger(RestSampleController.class);

	@GetMapping("/")
	public String healthCheck() {
		return "OK";
	}

	@GetMapping("/getSessionValue")
	@PostMapping("/getSessionValue")
	public String getSessionValue(HttpServletRequest request) {
		HttpSession session = request.getSession();
		log.info("session id [{}]", session.getId());
		return (String) session.getAttribute("key1");
	}

	@GetMapping("/getSessionId")
	@PostMapping("/getSessionId")
	public String getSessionId(HttpSession session) {
		session.setAttribute("key1", "abcde");
		log.debug(session.getId());
		return session.getId();
	}

	@GetMapping("/getValue")
	public String getValue(HttpSession session) {
		log.debug(session.getId());
		log.debug((String) session.getAttribute("key1"));
		return (String) session.getAttribute("key1");
	}
}
