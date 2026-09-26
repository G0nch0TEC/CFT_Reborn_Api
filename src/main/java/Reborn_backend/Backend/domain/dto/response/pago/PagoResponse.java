package Reborn_backend.Backend.domain.dto.response.pago;

import java.math.BigDecimal;

public class PagoResponse {
    private BigDecimal monto;

    public PagoResponse() {}

    public PagoResponse(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
