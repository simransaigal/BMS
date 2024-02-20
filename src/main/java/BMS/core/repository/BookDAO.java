package BMS.core.repository;

import BMS.core.entities.BookEntity;
import com.mysql.cj.xdevapi.SessionFactory;
import io.dropwizard.hibernate.AbstractDAO;

import java.util.List;

//public interface BookDAO {
//    @SqlUpdate("create table if not exists books (title varchar(100), isbn int primary key, category varchar(50), sellingPrice int, publishDate date)")
//    void createBooksTable();
//
//    @SqlUpdate("insert into books (title, isbn, category, sellingPrice, publishDate) values (:title, :isbn, :category, :sellingPrice, :publishDate)")
//    void add(@Bind("title") String title,@Bind("isbn") long isbn,@Bind("category") String category,@Bind("sellingPrice") int sellingPrice,@Bind("publishDate") Date publishDate);
//
//    @SqlQuery("select * from books")
//    List<BookEntity> get();
//}

public class BookDAO extends AbstractDAO<BookEntity> {
    public BookDAO(SessionFactory factory) {
        super((org.hibernate.SessionFactory) factory);
    }

    public BookEntity findById(Long id) {
        return get(id);
    }

    public BookEntity create(BookEntity book) {
        return persist(book);
    }

    public List<BookEntity> findAll() {
        return list(namedTypedQuery("BMS.core.entities.BookEntity.findAll"));
    }
}

