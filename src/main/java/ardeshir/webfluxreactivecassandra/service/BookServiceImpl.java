package ardeshir.webfluxreactivecassandra.service;

import ardeshir.webfluxreactivecassandra.domain.Book;
import ardeshir.webfluxreactivecassandra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    @Autowired
    BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public Flux<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Mono<Book> findBookByTitle(String title) {
        return this.bookRepository.findBookByBook_title(title);
    }

    @Override
    public Mono<Book> updateBook(Book book) {
        return this.bookRepository.insert(book);
    }

    @Override
    public Mono<Book> saveBook(Book book) {
        book.setBook_id(UUID.randomUUID());
        return this.bookRepository.save(book);
    }

    @Override
    public Mono<Void> deleteBook(UUID uuid) {
        return this.bookRepository.deleteById(uuid);
    }
}

