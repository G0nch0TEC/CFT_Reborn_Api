package Reborn_backend.Backend.domain.dto.response;

public class CrearCategoriaResponse {
    private String nombre;

    public CrearCategoriaResponse(){}

    public CrearCategoriaResponse(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
