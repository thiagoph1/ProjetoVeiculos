package com.projeto.veiculos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // para funcionar a autenticação na memoria
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/").permitAll() // Qualquer usuário acessa a pagina inicial
		//.antMatchers(HttpMethod.GET, "/usuario").hasAnyRole("ADMIN") // só o usuário ROLE_ADMIN acessa
		//.antMatchers(HttpMethod.GET, "/veiculo", "/motorista").hasAnyRole("GERENTE", "ADMIN") // gerente e admin acessam
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.defaultSuccessUrl("/dashboard")
		.and().logout().logoutSuccessUrl("/login")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(implementacaoUserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/img/**");
	}
}
