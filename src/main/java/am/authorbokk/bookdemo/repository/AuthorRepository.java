package am.authorbokk.bookdemo.repository;

import am.authorbokk.bookdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
        
}
