package br.com.fiap.postech.techchallenge.infrastructure.controllers.admin;

import br.com.fiap.postech.techchallenge.application.dto.product.CreateProductDto;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import br.com.fiap.postech.techchallenge.application.dto.product.UpdateProductDto;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.core.usecase.product.CreateProductUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.product.DeleteProductUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.product.UpdateProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/product")
public class AdminProductController {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid CreateProductDto createDto) throws EntityNotFoundException {
        var dto = createProductUseCase.create(createDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody UpdateProductDto updateDto) throws EntityNotFoundException {
        var dto = updateProductUseCase.update(id, updateDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        deleteProductUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
