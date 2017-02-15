package pl.tomekD.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.tomekD.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class PersonDaoImpl extends GenericDao<Person> implements PersonDao {


    @Override
    @Transactional
    public void delete(Long id) {
        Person person = entityManager.getReference(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    @Transactional
    public Person find(Long id) {
        return entityManager.find(Person.class, id);
    }


    @Override
    @Transactional
    public List<Person> getAll() {
        Query query = entityManager.createQuery("Select p From Person p");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Person> findBySurname(String surname) {
        Query query = entityManager.createQuery("Select p From Person p WHERE p.surname='"+surname+"'");
        return query.getResultList();
    }


}
