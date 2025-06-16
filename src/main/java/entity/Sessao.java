package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SESSAO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_votacao_iniciada")
    private LocalDateTime dataVotacaoIniciada;

    @Column(name = "dt_votacao_encerrada")
    private LocalDateTime dataVotacaoEncerrada;

    @ManyToOne
    @JoinColumn(name = "tb_pauta_id", nullable = false)
    private Pauta pauta;
}
