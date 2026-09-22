package Reborn_backend.Backend.domain.dto.response.categoria;

public class CategoriaResponse {
    private Integer idcat;
    private String nombre;

    public CategoriaResponse(){}

    public CategoriaResponse(Integer idcat, String nombre) {
        this.idcat = idcat;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdcat() {return idcat;}
    public void setIdcat(Integer idcat) {this.idcat = idcat;}
}
