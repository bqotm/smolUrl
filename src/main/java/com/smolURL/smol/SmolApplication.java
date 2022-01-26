package com.smolURL.smol;

import com.smolURL.smol.entities.UrlMapping;
import com.smolURL.smol.repository.UrlRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class SmolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmolApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UrlRepository urlRepository){
		return args->{
			UrlMapping urlMapping=new UrlMapping("y3s6d5", "somebodyoncetoldmetheworldisgonnarollme", LocalDateTime.now(), LocalDateTime.now().plusYears(2));
			urlRepository.insert(urlMapping);
		};
	}

}
