package Reborn_backend.Backend.domain.use_case.detalle_pedido;

import Reborn_backend.Backend.domain.dto.request.detalle_pedido.DetallePedidoRequest;
import Reborn_backend.Backend.domain.entities.Detalle_Pedido;
import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.repository.DetailOrderRepository;
import Reborn_backend.Backend.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CrearDetalleCase {
    private final DetailOrderRepository detailOrderRepository;
    private final ProductRepository productRepository;

    public CrearDetalleCase(DetailOrderRepository detailOrderRepository, ProductRepository productRepository) {
        this.detailOrderRepository = detailOrderRepository;
        this.productRepository = productRepository;
    }


    public void crearDetalle(DetallePedidoRequest detalleRequest, Pedido pedido) {
        // Buscamos el producto
        Producto producto = productRepository.findById(
                detalleRequest.getIdProducto()
        ).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Obtenemos el precio
        BigDecimal precio = producto.getPrecio();

        // Obtenemos la cantidad
        BigDecimal cantidad = BigDecimal.valueOf(
                detalleRequest.getCantidad()
        );

        // Calculamos subtotal
        BigDecimal subtotal = precio.multiply(cantidad);

        // Creamos el detalle
        Detalle_Pedido detalle = new Detalle_Pedido();
        detalle.setProducto(producto);
        detalle.setCantidad(detalleRequest.getCantidad());
        detalle.setPreciounitario(precio);
        detalle.setSubtotal(subtotal);
        detalle.setPedido(pedido);

        detailOrderRepository.save(detalle);
    }
}
