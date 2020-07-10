package am.authorbokk.bookdemo.repository;

import am.authorbokk.bookdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
        
}
