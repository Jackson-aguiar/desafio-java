package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "tb_voto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "tb_pauta_id")
    private Pauta pauta;

    @ManyToOne
    @JoinColumn(name = "tb_usuario_id")
    private Usuario usuario;

    @Column(name = "voto")
    private String voto;

}
