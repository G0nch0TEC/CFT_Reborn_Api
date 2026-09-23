package Reborn_backend.Backend.domain.dto.response.producto;

import java.math.BigDecimal;

public class ProductoResponse {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    public ProductoResponse(){}

    public ProductoResponse(Integer idProducto,
                            String nombre,
                            String descripcion,
                            BigDecimal precio){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdProducto() {return idProducto;}
    public void setIdProducto(Integer idProducto) {this.idProducto = idProducto;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
}
