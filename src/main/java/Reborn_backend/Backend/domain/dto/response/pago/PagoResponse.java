package Reborn_backend.Backend.domain.dto.response.pago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse {
    private BigDecimal monto;
    private LocalDateTime fecha;

    public PagoResponse() {}

    public PagoResponse(BigDecimal monto, LocalDateTime fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {return fecha;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
}
