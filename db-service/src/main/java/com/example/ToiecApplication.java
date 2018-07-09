package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
public class ToiecApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ToiecApplication.class, args);
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers("/user").permitAll().antMatchers("/quizs/1").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").
//		usernameParameter("username").passwordParameter("password").
//		defaultSuccessUrl("/quiz").failureUrl("/login?e=error").permitAll().and().logout().permitAll();
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/js/**","/css/**");
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userLoginServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
//	
//	}
//	
	//Scheduled
//	@Scheduled(fixedRate = 2000000)
//    public void scheduleTaskWithFixedRate() {
//        // call send email method here
//        System.out.println("Send email to producers to inform quantity sold items");
//    }
	
}
