package dao;

import entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDAO extends AbstractDao<Usuario, Long>{
    protected UsuarioDAO() {
        super(Usuario.class);
    }
}
