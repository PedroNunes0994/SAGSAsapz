package main.controllers;

import me.sagsa.api.models.SituacaoAprendizagem;
import me.sagsa.api.services.SituacaoAprendizagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/situacoes-aprendizagem")
public class SituacaoAprendizagemController {

    private final SituacaoAprendizagemService saService;

    public SituacaoAprendizagemController(SituacaoAprendizagemService saService) {
        this.saService = saService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoAprendizagem> findById(@PathVariable Long id) {
        SituacaoAprendizagem obj = saService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/minhas")
    public ResponseEntity<List<SituacaoAprendizagem>> findByInstrutor() {
        List<SituacaoAprendizagem> list = saService.findByInstrutorAutenticado();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SituacaoAprendizagem obj) {
        SituacaoAprendizagem createdObj = saService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}