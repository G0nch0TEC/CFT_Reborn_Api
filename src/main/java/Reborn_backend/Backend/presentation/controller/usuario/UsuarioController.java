package Reborn_backend.Backend.presentation.controller.usuario;

import Reborn_backend.Backend.domain.dto.request.usuario.UserRequest;
import Reborn_backend.Backend.domain.dto.response.usuario.UserResponse;
import Reborn_backend.Backend.domain.entities.Usuario;
import Reborn_backend.Backend.domain.use_case.usuario.RegistrarUsuarioCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //Dependencia del Use Case
    private final RegistrarUsuarioCase registrarUsuarioCase;

    //Constructor
    public UsuarioController(RegistrarUsuarioCase registrarUsuarioCase) {
        this.registrarUsuarioCase = registrarUsuarioCase;
    }


    @PostMapping
    public ResponseEntity<UserResponse> registrar(@RequestBody UserRequest userRequest) {

        Usuario usuario = new Usuario(); // Crear nuevo objeto dentro de Usuario
        usuario.setNombre(userRequest.getNombre());
        usuario.setEmail(userRequest.getEmail());
        usuario.setPassword(userRequest.getPassword());

        Usuario userRegister = registrarUsuarioCase.registrarUsuario(usuario);//Guardamos Usuario

        // Devolvemos Respuesta
        UserResponse userResponse = new UserResponse(
                userRegister.getNombre(),
                userRegister.getEmail()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
