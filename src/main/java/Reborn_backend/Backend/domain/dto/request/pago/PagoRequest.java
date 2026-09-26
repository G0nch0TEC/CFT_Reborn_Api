package Reborn_backend.Backend.domain.dto.request.pago;

import java.math.BigDecimal;

public class PagoRequest {
    private Integer idCliente;
    private BigDecimal monto;

    public PagoRequest() {}

    public PagoRequest(Integer idCliente, BigDecimal monto) {
        this.idCliente = idCliente;
        this.monto = monto;
    }

    public Integer getIdCliente() {return idCliente;}
    public void setIdCliente(Integer idCliente) {this.idCliente = idCliente;}

    public BigDecimal getMonto() {return monto;}
    public void setMonto(BigDecimal monto) {this.monto = monto;}
}
