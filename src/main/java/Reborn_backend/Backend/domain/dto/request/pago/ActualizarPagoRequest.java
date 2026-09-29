package Reborn_backend.Backend.domain.dto.request.pago;

import java.math.BigDecimal;

public class ActualizarPagoRequest {
    private BigDecimal monto;

    public ActualizarPagoRequest(){}

    public ActualizarPagoRequest(BigDecimal monto){
        this.monto = monto;
    }

    public BigDecimal getMonto() {return monto;}
    public void setMonto(BigDecimal monto) {this.monto = monto;}
}
