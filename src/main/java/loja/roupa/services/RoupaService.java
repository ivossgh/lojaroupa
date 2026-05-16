package loja.roupa.services;

import loja.roupa.dtos.RoupaDTO;
import loja.roupa.dtos.RoupaUpdateDTO;
import loja.roupa.models.Roupa;
import loja.roupa.repositories.RoupaRepository;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoupaService {

    private final RoupaRepository roupaRepository;

    public RoupaService(RoupaRepository roupaRepository){
        this.roupaRepository = roupaRepository;
    }

    public List<RoupaDTO> listarTodos(){
        return roupaRepository.findAll()
        .stream()
        .map(this::converteParaDTO)
        .collect(Collectors.toList());
    } 

    public Optional<RoupaDTO> buscarPorId(Long id){
        return roupaRepository.findById(id)
        .map(this::converteParaDTO);
    }


    public RoupaDTO criar(RoupaDTO dto){
        // O Model é o formato que o JPA entende e sabe salvar no banco
        Roupa roupa = converterParaModel(dto);

        Roupa roupaSalvo = roupaRepository.save(roupa);

        return converteParaDTO(roupaSalvo);
    }

    public RoupaDTO atualizar(Long id, RoupaDTO dto){

        Roupa roupaExistente = roupaRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roupa nao encontrada"));

        roupaExistente.setTitulo(dto.getTitulo());
        roupaExistente.setVendedor(dto.getVendedor());
        roupaExistente.setCategoria(dto.getCategoria());
        roupaExistente.setPreco(dto.getPreco());
        roupaExistente.setEstoque(dto.getEstoque());

        Roupa roupaAtualizada = roupaRepository.save(roupaExistente);
        return converteParaDTO(roupaAtualizada);

    }

    public RoupaDTO atualizarParcial(Long id, RoupaUpdateDTO dto){

        Roupa roupaExistente = roupaRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roupa nao encontrada"));


        if(dto.getTitulo() !=null){
            // SE o cliente mandou título (não nulo)  atualiza
            // SE não mandou (nulo)  mantém o título original do banco
            roupaExistente.setTitulo(dto.getTitulo());
        }

        if(dto.getVendedor() !=null){
            roupaExistente.setVendedor(dto.getVendedor());
        }

        if(dto.getCategoria() != null){
            roupaExistente.setCategoria(dto.getCategoria());
        }

        if(dto.getPreco() !=null){
            roupaExistente.setPreco(dto.getPreco());
        }

        if(dto.getEstoque() !=null){
            roupaExistente.setEstoque(dto.getEstoque());
        }

        Roupa roupaAtualizada = roupaRepository.save(roupaExistente);

        return converteParaDTO(roupaAtualizada);
    }   

    public void deletar(Long id){
        if(!roupaRepository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "roupa não encontrado");
        }

        roupaRepository.deleteById(id);
        // Executa: DELETE FROM livros WHERE id = ?
        // Sem retorno — void. O dado foi embora.
        // O Controller vai retornar 204 No Content.
    }


    public RoupaDTO converteParaDTO(Roupa roupa){
        RoupaDTO dto = new RoupaDTO();

        //É uma cópia manual de valores de um objeto para o outro.
        dto.setId(roupa.getId());
        dto.setTitulo(roupa.getTitulo());
        dto.setVendedor(roupa.getVendedor());
        dto.setCategoria(roupa.getCategoria());
        dto.setPreco(roupa.getPreco());
        dto.setEstoque(roupa.getEstoque());

        return dto;
    
    }

    public Roupa converterParaModel(RoupaDTO dto){
        Roupa roupa = new Roupa();

        roupa.setTitulo(dto.getTitulo());
        roupa.setVendedor(dto.getVendedor());
        roupa.setCategoria(dto.getCategoria());
        roupa.setPreco(dto.getPreco());
        roupa.setEstoque(dto.getEstoque());

        return roupa;

    }



}
