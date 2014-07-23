package uz.micros.jstore.service.store;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.store.Book;
import uz.micros.jstore.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private FileService fileSvc;

    @Autowired
    private FullTextEntityManager fullTextEntityManager;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getByGenre(int id) {
        return bookRepository.getByGenreId(id);
    }

    public Book getById(int id) {
        return bookRepository.findOne(id);
    }

    public Book save(Book book, byte[] file) {
        Book res = bookRepository.save(book);

        if (res != null) {
            if (file != null) {
                fileSvc.saveBookImage(res.getId(), file);
            }
        }

        return res;
    }

    public void delete(int id) {
        bookRepository.delete(id);
    }

    public List<Book> search(String query) {
        // each time???
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Book> books = fullTextEntityManager.createFullTextQuery(
                new WildcardQuery(
                        new Term("title", "*" + query + "*")), Book.class)
                .getResultList();

        return books;

        /*
        // use hibernate search query DSL
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Book.class).get();
        org.apache.lucene.search.Query qry = qb
                .keyword()
                .onFields("title")
                .matching("*" + query + "*")
                .createQuery();

        javax.persistence.Query persistenceQuery =
                fullTextEntityManager.createFullTextQuery(qry, Book.class);

        List result = persistenceQuery.getResultList();

        return (List<Book>)result;*/
    }
}
