package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import br.com.fiap.postech.techchallenge.core.usecase.product.FindAllProductByProductCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final FindAllProductByProductCategoryUseCase findAllProductByProductCategoryUseCase;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllByProductCategoryName(@RequestParam String categoryName) {
        var dtos = findAllProductByProductCategoryUseCase.find(categoryName);
        return ResponseEntity.ok(dtos);
    }
}
