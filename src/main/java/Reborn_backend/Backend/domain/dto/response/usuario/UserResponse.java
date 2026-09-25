package Reborn_backend.Backend.domain.dto.response.usuario;

public class UserResponse {
    private String nombre;
    private String correo;

    public UserResponse() {}

    public UserResponse(String usuario, String correo) {
        this.nombre = usuario;
        this.correo = correo;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String usuario) {this.nombre = nombre;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
}
