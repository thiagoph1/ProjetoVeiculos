package com.projeto.veiculos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", "/resources/**").permitAll()
		/* somente o administrador pode acesso a tela de usuários */
		.antMatchers("/usuarios", "/cadastroAdmin", "/cadastroGerente").hasRole("ADMIN")
		/* o administrador e o gerente podem acessar as telas de veículos e motoristas */
		.antMatchers("/motoristas", "/veiculos","/cadastroMotorista", "/cadastroVeiculo", "/editarveiculo/**",
						"/removerveiculo/**").access
						("hasRole('ADMIN') or hasRole('GERENTE')") 
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/dashboard")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll().and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler);;
		
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
