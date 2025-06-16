package dao;

import entity.Pauta;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PautaDAO extends AbstractDao<Pauta, Long>{
    protected PautaDAO() {
        super(Pauta.class);
    }

}
