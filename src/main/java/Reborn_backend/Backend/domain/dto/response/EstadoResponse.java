package Reborn_backend.Backend.domain.dto.response;

public class EstadoResponse {
    private Integer id;
    private String nombre;

    public EstadoResponse() {}

    public EstadoResponse(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
}
