package ardeshir.webfluxreactivecassandra.service;

import ardeshir.webfluxreactivecassandra.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BookService {
    Flux<Book> findAllBooks();
    Mono<Book> findBookByTitle(String title);
    Mono<Book> updateBook(Book book);
    Mono<Book> saveBook(Book book);
    Mono<Void> deleteBook(UUID uuid);
}
