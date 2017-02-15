package pl.tomekD.dao;

import pl.tomekD.model.Person;

import java.util.List;


public interface PersonDao {
    void save(Person person);
    List<Person> getAll();
    List<Person> findBySurname(String surname);
    void delete(Long id);
    Person find(Long id);
}
