package Reborn_backend.Backend.Infraestructure.SecurityConfig;

import Reborn_backend.Backend.domain.entities.Usuario;
import Reborn_backend.Backend.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioDetails implements UserDetailsService {
    private final UserRepository userRepository;

    public UsuarioDetails(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        Usuario usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El correo no esta registrado"));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .build();
    }
}
