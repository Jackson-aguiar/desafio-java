package service;

import dao.SessaoDAO;
import dto.SessaoDTO;
import entity.Pauta;
import entity.Sessao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import mapper.SessaoMapper;

import java.time.LocalDateTime;
import java.util.Objects;

@ApplicationScoped
public class SessaoService {

    @Inject
    SessaoDAO sessaoDAO;
    @Inject
    PautaService pautaService;
    @Inject
    SessaoMapper mapper;

    public SessaoDTO abrirSessao(Long idPauta, Long minutos) throws IllegalArgumentException, NotFoundException {
        if(sessaoJaExistente(idPauta)){
            throw new IllegalArgumentException("A sessão já se encontra aberta");
        }

        Pauta pauta = pautaService.buscarPautaPorId(idPauta);
        if(Objects.isNull(pauta)){
            throw new NotFoundException("Pauta não encontrada para o ID:" + idPauta);
        }

        LocalDateTime abertura = LocalDateTime.now();
        LocalDateTime fechamento = abertura.plusMinutes(minutos);

        Sessao sessao = new Sessao(null, abertura, fechamento, pauta);

        sessaoDAO.save(sessao);

        return mapper.toDTO(sessao);
    }

    public Boolean sessaoJaExistente(Long idPauta){
        Sessao sessao = sessaoDAO.existByPauta(idPauta);
        if(Objects.isNull(sessao)){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public Boolean sessaoEstaFechada(Long idPauta) {
        Sessao sessao = sessaoDAO.existByPauta(idPauta);
        if(Objects.isNull(sessao)){
            return Boolean.TRUE;
        }

        LocalDateTime agora = LocalDateTime.now();

        if(agora.isAfter(sessao.getDataVotacaoEncerrada())){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
