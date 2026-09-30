package Reborn_backend.Backend.domain.dto.response.cliente;

public class MostrarClientesPorEstadoResponse {
    private Integer idCliente;
    private String nombre;
    private String descripcion;

    public MostrarClientesPorEstadoResponse() {}

    public MostrarClientesPorEstadoResponse(Integer idCliente, String nombre, String descripcion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdCliente() {return idCliente;}
    public void setIdCliente(Integer idCliente) {this.idCliente = idCliente;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
