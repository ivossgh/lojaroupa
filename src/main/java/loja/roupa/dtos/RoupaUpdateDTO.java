package loja.roupa.dtos;


import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoupaUpdateDTO {


    @Size(max = 200, message = "Titulo deve ter no maximo 200 caracteres")
    private String titulo;


    @Size(max = 200, message = "Nome do vendedor deve ter no maximo 200 caracteres")
    private String vendedor;

    @Size(max = 200, message = "Categoria deve ter no maximo 25 caracteres")
    private String categoria;


    @Min(value = 0, message = "Estoque não pode ser negativo")
    private Integer estoque;


    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
    private BigDecimal preco;

}
