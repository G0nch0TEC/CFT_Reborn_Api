package Reborn_backend.Backend.domain.dto.response.usuario;

public class UserResponse {
    private String usuario;
    private String correo;

    public UserResponse() {}

    public UserResponse(String usuario, String correo) {
        this.usuario = usuario;
        this.correo = correo;
    }

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
}
