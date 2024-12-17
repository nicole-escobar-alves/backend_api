package br.com.fiap.postech.techchallenge.infrastructure.controllers.admin;

import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.CreateAddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.UpdateAddonDto;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.core.usecase.addon.CreateAddonUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.addon.DeleteAddonUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.addon.UpdateAddonUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/addon")
public class AdminAddonController {

    private final CreateAddonUseCase createAddonUseCase;
    private final UpdateAddonUseCase updateAddonUseCase;
    private final DeleteAddonUseCase deleteAddonUseCase;

    @PostMapping
    public ResponseEntity<AddonDto> create(@RequestBody @Valid CreateAddonDto dto){
        var response = createAddonUseCase.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddonDto> update(@PathVariable Long id, @RequestBody @Valid UpdateAddonDto dto) throws EntityNotFoundException {
        var response = updateAddonUseCase.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        deleteAddonUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}