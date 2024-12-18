package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.application.dto.order.CreateOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.core.usecase.order.CreateOrderUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.order.FindAllOrdersByCustomerUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.order.FindOrderByIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final FindAllOrdersByCustomerUseCase findAllOrdersByCustomerUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final CreateOrderUseCase createOrderUseCase;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrdersByCostumer(@RequestParam String cpf){
        return ResponseEntity.ok(findAllOrdersByCustomerUseCase.find(cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsOrderDto> getOrderById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(findOrderByIdUseCase.find(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody @Valid CreateOrderDto orderDto) throws EntityNotFoundException {
        var order = createOrderUseCase.create(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
