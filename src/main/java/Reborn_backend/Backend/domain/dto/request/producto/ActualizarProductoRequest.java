package Reborn_backend.Backend.domain.dto.request.producto;

import java.math.BigDecimal;

public class ActualizarProductoRequest {
    private String nombre;
    private BigDecimal precio;

    public ActualizarProductoRequest(){}

    public ActualizarProductoRequest(String nombre,
                                     BigDecimal precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
}
