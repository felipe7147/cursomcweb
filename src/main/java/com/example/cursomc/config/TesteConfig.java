package com.example.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.example.cursomc.services.DBService;
import com.example.cursomc.services.EmailService;
import com.example.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TesteConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public JavaMailSender javaMailSender() {
		return new JavaMailSenderImpl();
	}
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
