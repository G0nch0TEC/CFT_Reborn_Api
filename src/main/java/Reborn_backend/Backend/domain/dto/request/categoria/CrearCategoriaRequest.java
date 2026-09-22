package Reborn_backend.Backend.domain.dto.request.categoria;

public class CrearCategoriaRequest {
    private String nombre;

    public CrearCategoriaRequest(){}

    public CrearCategoriaRequest(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
