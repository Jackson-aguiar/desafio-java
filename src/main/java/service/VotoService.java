package service;

import dao.VotoDAO;
import dto.ResultadoDTO;
import dto.VotoDTO;
import entity.Pauta;
import entity.Usuario;
import entity.Voto;
import exception.VotacaoException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Objects;

@ApplicationScoped
public class VotoService {

    @Inject
    VotoDAO votoDAO;

    public void registrarVoto(Pauta pauta, Usuario usuario, VotoDTO votoDTO) throws Exception {
        Boolean exist = votoDAO.existVotoByUserAndPauta(pauta.getId(), votoDTO.getIdUsuario());

        if(exist){
            throw new RuntimeException("Voto já registrado");
        }

        Voto voto = new Voto(null, null, pauta, usuario, votoDTO.getVoto());

        votoDAO.save(voto);
    }

    public ResultadoDTO resultadoVotacao(Long idPauta){
        ResultadoDTO resultadoDTO = votoDAO.resultadoVotacao(idPauta);
        if(Objects.isNull(resultadoDTO.getVotosAfavor()) && Objects.isNull(resultadoDTO.getVotosContra())){
            throw new VotacaoException("Nenhum voto encontrado");
        }
        return resultadoDTO;
    }

}
