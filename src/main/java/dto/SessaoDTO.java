package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SessaoDTO {

    private Long id;
    private LocalDateTime dataVotacaoIniciada;
    private LocalDateTime dataVotacaoEncerrada;
    private Long idPauta;
}
