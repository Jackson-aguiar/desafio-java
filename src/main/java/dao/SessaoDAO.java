package dao;

import entity.Sessao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class SessaoDAO extends AbstractDao<Sessao, Long>{
    protected SessaoDAO() {
        super(Sessao.class);
    }

    public Sessao existByPauta(Long id){
        Map<String, Object> parametros = new HashMap<>();

        String query = " SELECT s FROM Sessao s WHERE s.pauta.id = :idPauta";
        parametros.put("idPauta", id);

        try {
            return findWithQuery(query, Sessao.class, parametros);
        }catch (NoResultException e){
            return null;
        }

    }
}
