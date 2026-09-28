package Reborn_backend.Backend.domain.dto.request.producto;

import java.math.BigDecimal;

public class ActualizarProductoRequest {
    private Integer id;
    private String nombre;
    private BigDecimal precio;

    public ActualizarProductoRequest(){}

    public ActualizarProductoRequest(Integer id,
                                     String nombre,
                                     BigDecimal precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
}
