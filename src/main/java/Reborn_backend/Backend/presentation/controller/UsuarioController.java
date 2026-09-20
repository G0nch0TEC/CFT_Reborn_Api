package Reborn_backend.Backend.presentation.controller;

import Reborn_backend.Backend.domain.dto.request.RegisterUserRequest;
import Reborn_backend.Backend.domain.dto.response.RegisterUserResponse;
import Reborn_backend.Backend.domain.entities.Usuario;
import Reborn_backend.Backend.domain.use_case.Usuario.RegistrarUsuarioCase;
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


    @PostMapping("/registrar")
    public ResponseEntity<RegisterUserResponse> registrar(@RequestBody RegisterUserRequest registerUserRequest) {

        Usuario usuario = new Usuario(); // Crear nuevo objeto dentro de Usuario
        usuario.setUsuario(registerUserRequest.getUsuario());
        usuario.setCorreo(registerUserRequest.getCorreo());
        usuario.setPassword(registerUserRequest.getPassword());

        Usuario userRegister = registrarUsuarioCase.registrarUsuario(usuario);//Guardamos Usuario

        // Devolvemos Respuesta
        RegisterUserResponse registerUserResponse = new RegisterUserResponse(
                userRegister.getUsuario(),
                userRegister.getCorreo()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUserResponse);
    }
}
