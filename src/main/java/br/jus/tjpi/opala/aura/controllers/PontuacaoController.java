package br.jus.tjpi.opala.aura.controllers;

import br.jus.tjpi.opala.aura.dtos.PontuacaoDto;
import br.jus.tjpi.opala.aura.models.PontuacaoModel;
import br.jus.tjpi.opala.aura.services.PontuacaoService;
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
@RequestMapping("/pontuacao")
public class PontuacaoController {

    final PontuacaoService pontuacaoService;

    public PontuacaoController(PontuacaoService pontuacaoService) {
        this.pontuacaoService = pontuacaoService;
    }

    // Inclusão
    @Transactional
    @PostMapping
    public ResponseEntity<Object> incluir(@RequestBody @Valid PontuacaoDto pontuacaoDto){
        PontuacaoModel pontuacaoModel = new PontuacaoModel();
        BeanUtils.copyProperties(pontuacaoDto, pontuacaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pontuacaoService.salvar(pontuacaoModel));
    }

    // Listagem total
    @GetMapping
    public ResponseEntity<List<PontuacaoModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.CREATED).body(pontuacaoService.listarTodos());
    }

    // Listagem única
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarUm(@PathVariable (value = "id") Long id){
        Optional<PontuacaoModel> pontuacaoModelOptional = pontuacaoService.listarUm(id);
        if (!pontuacaoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pontuacao não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pontuacaoModelOptional.get());

    }

    // Listagem por eixo
    @GetMapping("/eixo/{id}")
    public ResponseEntity<Object> listarPorAno(@PathVariable (value = "id") Long id){
        List<PontuacaoModel> pontuacaoModelList = pontuacaoService.listarPorEixo(id);
        if (pontuacaoModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registros não encontrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pontuacaoModelList);
    }

    // Exclusão
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable (value = "id") Long id){
        Optional<PontuacaoModel> pontuacaoModelOptional = pontuacaoService.listarUm(id);

        if (!pontuacaoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pontuacao não encontrado");
        }

        pontuacaoService.excluir(pontuacaoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(pontuacaoModelOptional.get());
    }

    // Atualização
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable (value = "id") Long id, @RequestBody @Valid PontuacaoDto pontuacaoDto){
        Optional<PontuacaoModel> pontuacaoModelOptimal = pontuacaoService.listarUm(id);

        if (!pontuacaoModelOptimal.isPresent())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pontuacao não encontrado");
        }

        var pontuacaoModel = pontuacaoModelOptimal.get();
        pontuacaoModel.setArtigo(pontuacaoDto.getArtigo());
        pontuacaoModel.setDescPontuacao(pontuacaoDto.getDescPontuacao());
        pontuacaoModel.setMaxPontos(pontuacaoDto.getMaxPontos());
        pontuacaoModel.setEixo(pontuacaoDto.getEixo());

        return ResponseEntity.status(HttpStatus.OK).body(pontuacaoService.salvar(pontuacaoModel));

    }

}
