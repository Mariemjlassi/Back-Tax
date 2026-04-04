package com.projet.app.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.dto.EmailDTO;
import com.projet.app.services.EmailService;

@RestController
@RequestMapping("/sendmail")
public class EmailController {
	
	private EmailService emailService;
	
	 public EmailController(EmailService emailService) {
	        this.emailService = emailService;
	    }
	 
	 @PostMapping
	    public String sendMail(@RequestBody EmailDTO emailDTO) {
		 return this.emailService.sendEmail(emailDTO.getTo(), emailDTO.getCc(), emailDTO.getSubject(), emailDTO.getBody());
	    }

}
