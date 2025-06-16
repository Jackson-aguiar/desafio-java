package mapper;

import dto.PautaDTO;
import entity.Pauta;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class PautaMapper {
    public Pauta toEntity(PautaDTO pautaDTO){
        if(Objects.isNull(pautaDTO)) return null;
        return new Pauta(null, pautaDTO.getNome(), pautaDTO.getDescricao(), null);
    }

    public PautaDTO toDTO(Pauta pauta){
        if(Objects.isNull(pauta)) return null;
        return new PautaDTO(pauta.getId(), pauta.getNome(), pauta.getDescricao(), pauta.getDataCriacao());
    }
}
