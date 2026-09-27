package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.entities.Estado;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import Reborn_backend.Backend.domain.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CambiarEstadoClienteCase {
    private final ClientRepository clientRepository;
    private final StateRepository stateRepository;
    private final CalcularSaldoClienteCase calcularSaldoClienteCase;

    public  CambiarEstadoClienteCase(ClientRepository clientRepository,
                                     StateRepository stateRepository,
                                     CalcularSaldoClienteCase calcularSaldoClienteCase){
        this.clientRepository = clientRepository;
        this.stateRepository = stateRepository;
        this.calcularSaldoClienteCase = calcularSaldoClienteCase;
    }

    public void cambiarEstadoCliente(Integer idCliente){
        //Calcular el saldo
        BigDecimal saldo = calcularSaldoClienteCase.calcularSaldoCliente(idCliente);

        // Determinado estado segun saldo
        Estado estado;
        if (saldo.compareTo(BigDecimal.ZERO) > 0){
            estado = stateRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        } else if (saldo.compareTo(BigDecimal.ZERO) == 0){
            estado  = stateRepository.findById(2)
                    .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        } else {
            estado = stateRepository.findById(3)
                    .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        }

        clientRepository.actualizarEstado(idCliente, estado.getId());
    }
}
