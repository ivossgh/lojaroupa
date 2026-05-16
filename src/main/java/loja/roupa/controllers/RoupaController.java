package loja.roupa.controllers;

import org.springframework.web.bind.annotation.RestController;
import loja.roupa.dtos.RoupaDTO;
import loja.roupa.dtos.RoupaUpdateDTO;
import loja.roupa.services.RoupaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/Roupas")
public class RoupaController {

    private final RoupaService roupaService;

    public RoupaController(RoupaService roupaService){
        this.roupaService = roupaService;
    }

    @GetMapping
    public ResponseEntity<List<RoupaDTO>> listarTodos(){
        List<RoupaDTO> roupas = roupaService.listarTodos(); 

        return ResponseEntity.ok(roupas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoupaDTO> buscarPorId(@PathVariable Long id){
        return roupaService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<RoupaDTO> criar(@RequestBody @Valid RoupaDTO dto){
        RoupaDTO roupaCriada = roupaService.criar(dto);

        URI location = URI.create("/Roupas" + roupaCriada.getId());

        return ResponseEntity.created(location).body(roupaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoupaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid RoupaDTO dto){

        RoupaDTO atualizado = roupaService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoupaDTO> atualizarParcial(@PathVariable Long id, @RequestBody @Valid RoupaUpdateDTO dto){

        RoupaDTO atualizado = roupaService.atualizarParcial(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        // ResponseEntity<Void> = resposta sem body
        // Void é o tipo Java para "nada"
        // DELETE não retorna dados — só confirma que aconteceu        
        roupaService.deletar(id);

        return ResponseEntity.noContent().build();
        // .noContent() → status 204 No Content
        // .build() → sem body (diferente de .body(...))
        //
        // Analogia: a secretária confirma o cancelamento
        // sem entregar nenhum documento — só acena com a cabeça.        
    }

    
}
