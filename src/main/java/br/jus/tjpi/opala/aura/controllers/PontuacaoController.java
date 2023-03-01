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
        pontuacaoModel.setDescricaoItem(pontuacaoDto.getDescricaoItem());
        pontuacaoModel.setMaxPontos(pontuacaoDto.getMaxPontos());
        pontuacaoModel.setTjpiPontos(pontuacaoDto.getTjpiPontos());
        pontuacaoModel.setFormaComprovacao(pontuacaoDto.getFormaComprovacao());
        pontuacaoModel.setInicioPerRef(pontuacaoDto.getInicioPerRef());
        pontuacaoModel.setFinalPerRef(pontuacaoDto.getFinalPerRef());

        return ResponseEntity.status(HttpStatus.OK).body(pontuacaoService.salvar(pontuacaoModel));

    }

}
