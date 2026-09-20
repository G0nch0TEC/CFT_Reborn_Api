package Reborn_backend.Backend.domain.dto.response;

public class RegisterUserResponse {
    private String usuario;
    private String correo;

    public RegisterUserResponse() {}

    public RegisterUserResponse(String usuario, String correo) {
        this.usuario = usuario;
        this.correo = correo;
    }

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
}
