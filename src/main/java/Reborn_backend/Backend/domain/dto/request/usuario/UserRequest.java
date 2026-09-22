package Reborn_backend.Backend.domain.dto.request.usuario;

public class UserRequest {
    private String usuario;
    private String correo;
    private String password;

    public UserRequest() {}

    public UserRequest(String usuario, String correo, String password) {
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
    }

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
