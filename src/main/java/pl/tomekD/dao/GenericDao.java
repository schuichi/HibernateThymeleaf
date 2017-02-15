package pl.tomekD.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.tomekD.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public abstract class GenericDao <T> {


    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public void save(T person) { entityManager.persist(person); }
}
