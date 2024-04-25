package com.cursos.springsecuritycourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCourseApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner createPasswordCommand(){
//		return args -> {
//			System.out.println(this.passwordEncoder().encode("clave123"));
//			System.out.println(this.passwordEncoder().encode("clave456"));
//		};
//	}
//
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
}
