package loja.roupa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loja.roupa.models.Roupa;

@Repository
public interface RoupaRepository extends JpaRepository<Roupa, Long>{
    List<Roupa> findByVendedor(String vendedor);

    List<Roupa> findByCategoria(String categoria);

    
}
