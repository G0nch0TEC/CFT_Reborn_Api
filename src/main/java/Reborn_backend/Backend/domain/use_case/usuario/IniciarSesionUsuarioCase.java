package Reborn_backend.Backend.domain.use_case.usuario;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class IniciarSesionUsuarioCase {
    private final AuthenticationManager authenticationManager;

    public IniciarSesionUsuarioCase(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    public String IniciarSesion(String email, String password){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
        } catch (AuthenticationException exception){
            throw new BadCredentialsException("Credenciales Invalidas");
        }

        // aun falta añadir el jwt

        return "Login existoso";
    }
}
