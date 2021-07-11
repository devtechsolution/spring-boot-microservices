package org.as.devtechsolution.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {

		httpSecurity.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
				.oauth2Login(withDefaults());
		
		httpSecurity.csrf().disable();

		return httpSecurity.build();

	}

}