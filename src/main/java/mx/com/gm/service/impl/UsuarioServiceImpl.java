package mx.com.gm.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.entities.Rol;
import mx.com.gm.entities.Usuario;
import mx.com.gm.repository.UsuarioRepository;

@Service("userDetailsService")
@Slf4j
public class UsuarioServiceImpl implements UserDetailsService{
  
  
  @Autowired
  private UsuarioRepository usuarioRepository;
  
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
    Usuario usuario = usuarioRepository.findByUsername(username);
    if(usuario == null)
      throw new UsernameNotFoundException(username);
      List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
      
      for (Rol rol : usuario.getRoles()) {
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));
      }
      return new User(usuario.getUsername() , usuario.getPassword() , roles);
  }
  
  
    
  
}
