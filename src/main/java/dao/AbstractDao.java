package dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractDao<E, ID extends Serializable> {

    private final Class<E> entity;

    protected AbstractDao(Class<E> entity){
        this.entity = entity;
    }

    @Getter
    @Inject
    protected EntityManager entityManager;

    @Transactional
    public void save(E entity){
        entityManager.persist(entity);
    }

    @Transactional
    public E update(E entity){
        return entityManager.merge(entity);
    }

    public void delete(){
        entityManager.remove(entity);
    }

    public E find(ID id){
        return entityManager.find(entity, id);
    }

    public <E> E findWithQuery(String query, Class<E> object, Map<String, Object> parameters){
        TypedQuery<E> jpql = entityManager.createQuery(query, object);

        if(Objects.nonNull(parameters) && !parameters.isEmpty()){
            parameters.forEach(jpql::setParameter);
        }

        return jpql.getSingleResult();
    }

    public <E> List<E> findListWithQuery(String query, Class<E> object, Map<String, Object> parameters){
        TypedQuery<E> jpql = entityManager.createQuery(query, object);

        if(Objects.nonNull(parameters) && !parameters.isEmpty()){
            parameters.forEach(jpql::setParameter);
        }

        return jpql.getResultList();
    }

}
