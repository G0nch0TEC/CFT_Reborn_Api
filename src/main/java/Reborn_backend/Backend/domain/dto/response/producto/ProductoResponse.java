package Reborn_backend.Backend.domain.dto.response.producto;

import java.math.BigDecimal;

public class ProductoResponse {
    private Integer idProducto;
    private String nombre;
    private BigDecimal precio;

    public ProductoResponse(){}

    public ProductoResponse(Integer idProducto,
                            String nombre,
                            BigDecimal precio){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdProducto() {return idProducto;}
    public void setIdProducto(Integer idProducto) {this.idProducto = idProducto;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
}
