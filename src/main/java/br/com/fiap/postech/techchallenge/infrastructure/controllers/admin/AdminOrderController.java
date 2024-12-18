package br.com.fiap.postech.techchallenge.infrastructure.controllers.admin;

import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.core.usecase.order.FindAllOrdersByStatusUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.order.FindAllOrdersUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.order.UpdateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {


    private final FindAllOrdersByStatusUseCase findAllOrdersByStatusUseCase;
    private final FindAllOrdersUseCase findAllOrdersUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;

    @GetMapping("/status/{orderStatus}")
    public ResponseEntity<List<DetailsOrderDto>> getAllOrdersByStatus(@PathVariable OrderStatus orderStatus) throws EntityNotFoundException {
        var response = findAllOrdersByStatusUseCase.find(orderStatus);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/allStatus")
    public ResponseEntity<List<DetailsOrderDto>> getAllOrders() throws EntityNotFoundException{
        var response = findAllOrdersUseCase.findAll();
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}/{update}")
    public ResponseEntity<OrderDto> update(@RequestParam("id") Long id, @RequestParam("orderStatus") OrderStatus orderStatus) throws EntityNotFoundException {
        var dto = updateOrderUseCase.update(id, orderStatus);
        return ResponseEntity.ok(dto);
    }

}
