package br.jus.tjpi.opala.aura.controllers;

import br.jus.tjpi.opala.aura.dtos.EixoDto;
import br.jus.tjpi.opala.aura.models.EixoModel;
import br.jus.tjpi.opala.aura.services.EixoService;

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
@RequestMapping("/eixo")
public class EixoController {

    final EixoService eixoService;

    public EixoController(EixoService eixoService) {
        this.eixoService = eixoService;
    }

    // Inclusão
    @Transactional
    @PostMapping
    public ResponseEntity<Object> incluir(@RequestBody @Valid EixoDto eixoDto){
        EixoModel eixoModel = new EixoModel();
        BeanUtils.copyProperties(eixoDto, eixoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eixoService.salvar(eixoModel));
    }

    // Listagem total
    @GetMapping
    public ResponseEntity<List<EixoModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(eixoService.listarTodos());
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

    // Listagem por pontos
    @GetMapping("/pontos/{pontos}")
    public ResponseEntity<Object> listarUm(@PathVariable (value = "pontos") Integer pontos){
        List<EixoModel> eixoModelOptional = eixoService.listarPorMaxPontos(pontos);
        if (eixoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pontuação não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(eixoService.listarPorMaxPontos(pontos));
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
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable (value = "id") Long id){
        Optional<EixoModel> eixoModelOptional = eixoService.listarUm(id);

        if (!eixoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Eixo não encontrado");
        }

        eixoService.excluir(eixoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(eixoModelOptional.get());
    }

    // Atualização
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable (value = "id") Long id, @RequestBody @Valid EixoDto eixoDto){
        Optional<EixoModel> eixoModelOptimal = eixoService.listarUm(id);

        if (!eixoModelOptimal.isPresent())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Eixo não encontrado");
        }

        var eixoModel = eixoModelOptimal.get();
        eixoModel.setAno(eixoDto.getAno());
        eixoModel.setDescricao(eixoDto.getDescricao());
        eixoModel.setMaxPontos(eixoDto.getMaxPontos());
        eixoModel.setNumItensPontuacao(eixoDto.getNumItensPontuacao());
        eixoModel.setNumRequisitos(eixoDto.getNumRequisitos());

        return ResponseEntity.status(HttpStatus.OK).body(eixoService.salvar(eixoModel));

    }

}
