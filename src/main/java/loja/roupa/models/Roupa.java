package loja.roupa.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roupas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "vendedor", nullable = false, length = 200)
    private String vendedor;

    @Column(name = "categoria", length = 25)
    private String categoria;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "estoque", nullable = false)
    private Integer estoque;

}
