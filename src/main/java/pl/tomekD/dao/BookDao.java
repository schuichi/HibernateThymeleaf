package pl.tomekD.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekD.model.Book;


@Repository
public interface BookDao extends CrudRepository<Book, Long> {
}
