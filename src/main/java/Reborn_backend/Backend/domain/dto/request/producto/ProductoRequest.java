package Reborn_backend.Backend.domain.dto.request.producto;

import java.math.BigDecimal;

public class ProductoRequest {
    private String nombre;
    private BigDecimal precio;
    private Integer idCategoria;

    public ProductoRequest(){}

    public ProductoRequest(String nombre,
                           BigDecimal precio,
                           Integer idCategoria){
        this.nombre = nombre;
        this.precio = precio;
        this.idCategoria = idCategoria;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}

    public Integer getIdCategoria() {return idCategoria;}
    public void setIdCategoria(Integer idCategoria) {this.idCategoria = idCategoria;}
}
