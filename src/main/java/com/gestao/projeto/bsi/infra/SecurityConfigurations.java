package com.gestao.projeto.bsi.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations{

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
		return http.csrf(AbstractHttpConfigurer::disable)
			    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			    .authorizeHttpRequests(auth -> auth
			        .requestMatchers("/public/**").permitAll() // Endpoints públicos
			        .anyRequest().authenticated()            // Outros endpoints precisam de autenticação
			    )
			    .build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}
}
