package mapper;

import dto.SessaoDTO;
import entity.Sessao;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class SessaoMapper {
    public SessaoDTO toDTO(Sessao sessao){
        if(Objects.isNull(sessao)) return null;
        return new SessaoDTO(sessao.getId(), sessao.getDataVotacaoIniciada(), sessao.getDataVotacaoEncerrada(), sessao.getPauta().getId());
    }
}
