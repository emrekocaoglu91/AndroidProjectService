package com.deneme.Korku.Hikayeleri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.deneme.*")
@EnableJpaRepositories(basePackages = "com.deneme.*")
public class KorkuHikayeleriApplication {

	public static void main(String[] args) {

		SpringApplication.run(KorkuHikayeleriApplication.class, args);
	}
}
