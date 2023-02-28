package br.jus.tjpi.opala.aura.controllers;

import br.jus.tjpi.opala.aura.dtos.RequisitoDto;
import br.jus.tjpi.opala.aura.models.RequisitoModel;
import br.jus.tjpi.opala.aura.services.RequisitoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/requisito")
public class RequisitoController {

    final RequisitoService requisitoService;

    public RequisitoController(RequisitoService requisitoService) {
        this.requisitoService = requisitoService;
    }

    // Inclusão
    @Transactional
    @PostMapping
    public ResponseEntity<Object> incluir(@RequestBody @Valid RequisitoDto requisitoDto){
        RequisitoModel requisitoModel = new RequisitoModel();
        BeanUtils.copyProperties(requisitoDto, requisitoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(requisitoService.salvar(requisitoModel));
    }

    // Listagem total
    @GetMapping
    public ResponseEntity<List<RequisitoModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.CREATED).body(requisitoService.listarTodos());
    }

    // Listagem única
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarUm(@PathVariable (value = "id") Long id){
        Optional<RequisitoModel> requisitoModelOptional = requisitoService.listarUm(id);
        if (!requisitoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requisito não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(requisitoModelOptional.get());

    }

    // Listagem por eixo
    @GetMapping("/eixo/{id}")
    public ResponseEntity<Object> listarPorAno(@PathVariable (value = "id") Long id){
        List<RequisitoModel> requisitoModelList = requisitoService.listarPorEixo(id);
        if (requisitoModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registros não encontrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(requisitoModelList);
    }

    // Exclusão
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable (value = "id") Long id){
        Optional<RequisitoModel> requisitoModelOptional = requisitoService.listarUm(id);

        if (!requisitoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requisito não encontrado");
        }

        requisitoService.excluir(requisitoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(requisitoModelOptional.get());
    }

    // Atualização
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable (value = "id") Long id, @RequestBody @Valid RequisitoDto requisitoDto){
        Optional<RequisitoModel> requisitoModelOptimal = requisitoService.listarUm(id);

        if (!requisitoModelOptimal.isPresent())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requisito não encontrado");
        }

        var requisitoModel = requisitoModelOptimal.get();
        requisitoModel.setArtigo(requisitoDto.getArtigo());
        requisitoModel.setDescRequisito(requisitoDto.getDescRequisito());
        requisitoModel.setMaxPontos(requisitoDto.getMaxPontos());
        requisitoModel.setEixo(requisitoDto.getEixo());

        return ResponseEntity.status(HttpStatus.OK).body(requisitoService.salvar(requisitoModel));

    }

}
