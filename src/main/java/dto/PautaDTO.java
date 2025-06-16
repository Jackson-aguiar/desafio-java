package dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PautaDTO {

    private Long id;
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    @NotBlank(message = "O campo descricao é obrigatório")
    private String descricao;
    private LocalDateTime dataCriacao;
}
