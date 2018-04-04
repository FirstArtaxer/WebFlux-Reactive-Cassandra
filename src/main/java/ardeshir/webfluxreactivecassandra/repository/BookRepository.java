package ardeshir.webfluxreactivecassandra.repository;

import ardeshir.webfluxreactivecassandra.domain.Book;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface BookRepository extends ReactiveCassandraRepository<Book,UUID> {

    @Query("SELECT * FROM tblbook WHERE book_title=?0 ALLOW FILTERING")
    Mono<Book> findBookByBook_title(String title);
}
