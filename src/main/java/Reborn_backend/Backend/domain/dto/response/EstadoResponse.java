package Reborn_backend.Backend.domain.dto.response;

public class EstadoResponse {
    private String nombre;

    public EstadoResponse() {}

    public EstadoResponse(String nombre) {this.nombre = nombre;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
