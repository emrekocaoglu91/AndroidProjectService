package com.deneme.Korku.Hikayeleri;

import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.security.AppProperties;
import com.deneme.Korku.Hikayeleri.service.UserServiceImpl;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = "com.deneme.*")
@EnableJpaRepositories(basePackages = "com.deneme.*")
public class KorkuHikayeleriApplication {

	public static void main(String[] args) {

		SpringApplication.run(KorkuHikayeleriApplication.class, args);

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	public SpringApplicationContext springApplicationContext(){
		return new SpringApplicationContext();
	}

	@Bean(name = "AppProperties")
	public AppProperties getAppProperties(){
		return new AppProperties();
	}



}
