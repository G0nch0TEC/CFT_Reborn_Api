package Reborn_backend.Backend.domain.use_case.usuario;

import Reborn_backend.Backend.domain.entities.Usuario;
import Reborn_backend.Backend.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrarUsuarioCase {
    private final UserRepository userRepository;
    private final PasswordEncoder  passwordEncoder;

    public RegistrarUsuarioCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario registrarUsuario(Usuario usuario) {
        if (userRepository.existsByCorreo(usuario.getEmail())) {
            throw new RuntimeException("Este correo ya esta registrado");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userRepository.save(usuario);
    }
}
