package Reborn_backend.Backend.domain.use_case.Usuario;

import Reborn_backend.Backend.Infraestructure.repository.UserRepo;
import Reborn_backend.Backend.domain.entities.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrarUsuarioCase {
    private final UserRepo userRepo;
    private final PasswordEncoder  passwordEncoder;

    public RegistrarUsuarioCase(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario registrarUsuario(Usuario usuario) {
        if (userRepo.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("Este correo ya esta registrado");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userRepo.save(usuario);
    }
}
