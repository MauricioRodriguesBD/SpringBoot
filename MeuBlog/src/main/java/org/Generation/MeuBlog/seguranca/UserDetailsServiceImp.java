package org.Generation.MeuBlog.seguranca;

import java.util.Optional;

import org.Generation.MeuBlog.model.Usuario;
import org.Generation.MeuBlog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() ->  new UsernameNotFoundException(userName + " Não encontrado."));
		
		return user.map(UserDetailsImp::new).get();
		
	}
	
}
