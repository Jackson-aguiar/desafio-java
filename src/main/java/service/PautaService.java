package service;

import dao.PautaDAO;
import dto.PautaDTO;
import entity.Pauta;
import exception.PautaException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mapper.PautaMapper;

import java.util.Objects;

@ApplicationScoped
public class PautaService {

    @Inject
    PautaDAO pautaDAO;
    @Inject
    PautaMapper mapper;

    public PautaDTO criarPauta(PautaDTO pautaDTO) throws IllegalArgumentException {
        if(Objects.isNull(pautaDTO)) throw new PautaException("Pauta nula");
        Pauta pauta = mapper.toEntity(pautaDTO);
        this.pautaDAO.save(pauta);
        return mapper.toDTO(pauta);
    }

    public Pauta buscarPautaPorId(Long idPauta){
        Pauta pauta = pautaDAO.find(idPauta);
        if(Objects.isNull(pauta)){
            throw new PautaException("Pauta não encontrada");
        }
        return pauta;
    }

}
