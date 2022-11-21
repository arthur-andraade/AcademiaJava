package br.atos.petshop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.atos.petshop.model.Usuario;
import br.atos.petshop.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {
	
	private final UsuarioRepository repository;
	
	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repository.findByUserName(username)
				.orElseThrow(()-> new UsernameNotFoundException("Usuario " + username + " não encontrado"));
		
		return usuario;
	}

}
