package service;

import dao.UsuarioDAO;
import dto.VotoDTO;
import entity.Pauta;
import entity.Usuario;
import enums.VotoEnum;
import exception.VotacaoException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Objects;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioDAO usuarioDAO;
    @Inject
    PautaService pautaService;
    @Inject
    SessaoService sessaoService;
    @Inject
    VotoService votoService;

    public void votar(Long idPauta, VotoDTO votoDTO) throws Exception {
        if(Objects.isNull(votoDTO)){
            throw new VotacaoException("Informações de voto estão nulas");
        }
        if(!Objects.equals(votoDTO.getVoto(), VotoEnum.SIM.getVoto()) && !Objects.equals(votoDTO.getVoto(), VotoEnum.NAO.getVoto())){
            throw new VotacaoException("Voto inválido");
        }

        Usuario usuario = usuarioDAO.find(votoDTO.getIdUsuario());

        if(Objects.isNull(usuario)){
            throw new VotacaoException("Usuário não encontrado");
        }

        Pauta pauta = pautaService.buscarPautaPorId(idPauta);

        if(sessaoService.sessaoEstaFechada(pauta.getId())){
            throw new VotacaoException("Votação da pauta está encerrada");
        }

        votoService.registrarVoto(pauta, usuario, votoDTO);

    }
}
