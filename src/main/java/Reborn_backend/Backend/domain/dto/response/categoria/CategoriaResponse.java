package Reborn_backend.Backend.domain.dto.response.categoria;

public class CategoriaResponse {
    private Integer id;
    private String nombre;

    public CategoriaResponse(){}

    public CategoriaResponse(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
}
