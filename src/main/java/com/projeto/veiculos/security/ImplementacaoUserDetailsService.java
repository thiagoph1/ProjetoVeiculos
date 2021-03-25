package com.projeto.veiculos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.veiculos.models.Usuario;
import com.projeto.veiculos.repositories.UsuarioRepository;

@Service
@Transactional
public class ImplementacaoUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRp;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRp.findByLogin(login);

		if (usuario == null) {
			throw new UsernameNotFoundException("usuário não fo encontrado");
		}

		return new User(usuario.getLogin(), usuario.getPassword(), usuario.isEnabled(), true, true, true,
				usuario.getAuthorities());
	}

}
