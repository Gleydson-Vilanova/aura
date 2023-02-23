package br.jus.tjpi.opala.aura.controllers;

import br.jus.tjpi.opala.aura.dtos.EixoDto;
import br.jus.tjpi.opala.aura.models.EixoModel;
import br.jus.tjpi.opala.aura.services.EixoService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/eixo")
public class EixoController {

    final EixoService eixoService;

    public EixoController(EixoService eixoService) {
        this.eixoService = eixoService;
    }

    // Inclusão
    @PostMapping
    public ResponseEntity<Object> incluir(@RequestBody @Valid EixoDto eixoDto){
        EixoModel eixoModel = new EixoModel();
        BeanUtils.copyProperties(eixoDto, eixoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eixoService.salvar(eixoModel));
    }

    // Listagem total
    @GetMapping
    public ResponseEntity<List<EixoModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.CREATED).body(eixoService.listarTodos());
    }

    // Listagem única
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarUm(@PathVariable (value = "id") Long id){
        Optional<EixoModel> eixoModelOptional = eixoService.listarUm(id);
        if (!eixoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Eixo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(eixoModelOptional.get());
    }

    // Listagem por ano
    @GetMapping("/ano/{ano}")
    public ResponseEntity<Object> listarPorAno(@PathVariable (value = "ano") Integer ano){
        List<EixoModel> eixoModelList = eixoService.listarPorAno(ano);
        if (eixoModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registros não encontrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(eixoModelList);
    }

    // Exclusão
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable (value = "id") Long id){
        Optional<EixoModel> eixoModelOptional = eixoService.listarUm(id);
        if (!eixoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Eixo não encontrado");
        }
        eixoService.excluir(eixoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(eixoModelOptional.get());
    }
}
