package dao;

import dto.ResultadoDTO;
import entity.Voto;
import exception.VotacaoException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ApplicationScoped
public class VotoDAO extends AbstractDao<Voto, Long> {
    protected VotoDAO() {
        super(Voto.class);
    }

    public Boolean existVotoByUserAndPauta(Long idPauta, Long idUsuario){
        Map<String, Object> parameters = new HashMap<>();
        String query = "SELECT v FROM Voto v WHERE v.usuario.id = :usuario AND v.pauta.id = :pauta";

        parameters.put("usuario", idUsuario);
        parameters.put("pauta", idPauta);

        List<Voto> voto = findListWithQuery(query, Voto.class, parameters);

        if(Objects.isNull(voto) || voto.isEmpty()){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public ResultadoDTO resultadoVotacao(Long idPauta){
        Map<String, Object> parameters = new HashMap<>();

        String query = "SELECT SUM(CASE WHEN v.voto = 'SIM' THEN 1 ELSE 0 END) AS votosAfavor, " +
        " SUM(CASE WHEN v.voto = 'NAO' THEN 1 ELSE 0 END) AS votosContra " +
        " FROM Voto v WHERE v.pauta.id = :idPauta ";

        parameters.put("idPauta", idPauta);

        try{
            return findWithQuery(query, ResultadoDTO.class, parameters);
        } catch (NotFoundException e){
            throw new VotacaoException("Nenhum voto encontrado");
        }
    }
}
