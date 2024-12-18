package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.core.usecase.addon.FindAllAddonsByProductCategoryUseCase;
import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addon")
public class AddonController {

    private final FindAllAddonsByProductCategoryUseCase findAllAddonsByProductCategoryUseCase;

    @GetMapping
    public ResponseEntity<List<AddonDto>> listAllByProductCategory(@RequestParam String categoryName){
        var response = findAllAddonsByProductCategoryUseCase.find(categoryName);
        return ResponseEntity.ok(response);
    }
}
