package loja.roupa.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoupaDTO {

    private Long id;

    @NotBlank(message = "Titulo da roupa é obrigatorio")
    @Size(max = 200, message = "Titulo deve ter no maximo 200 caracteres")
    private String titulo;

    @NotBlank(message = "Vendedor da roupa é obrigatorio")
    @Size(max = 200, message = "Nome do vendedor deve ter no maximo 200 caracteres")
    private String vendedor;

    @Size(max = 200, message = "Categoria deve ter no maximo 25 caracteres")
    private String categoria;

    @NotNull(message = "Estoque é obrigatório")
    @Min(value = 0, message = "Estoque não pode ser negativo")
    private Integer estoque;

    @NotNull(message = "Preço é obrigatorio")
    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
    private BigDecimal preco;
}
