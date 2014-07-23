package uz.micros.jstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uz.micros.jstore.entity.store.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>,
        JpaSpecificationExecutor<Book> {
    List<Book> getByGenreId(int id);
}
