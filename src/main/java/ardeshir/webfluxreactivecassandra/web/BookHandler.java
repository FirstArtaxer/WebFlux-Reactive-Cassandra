package ardeshir.webfluxreactivecassandra.web;

import ardeshir.webfluxreactivecassandra.domain.Book;
import ardeshir.webfluxreactivecassandra.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class BookHandler {
    private final BookServiceImpl bookServiceImpl;
    @Autowired
    BookHandler(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    public Mono<ServerResponse> getAllBooks(ServerRequest serverRequest) {
        return ServerResponse.ok().body(bookServiceImpl.findAllBooks(),Book.class);
    }
    public Mono<ServerResponse> getBookByTtile(ServerRequest serverRequest) {
        String title =serverRequest.pathVariable("title");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return this.bookServiceImpl.findBookByTitle(title)
                .flatMap(book -> ServerResponse.ok().body(Mono.just(book), Book.class))
                .switchIfEmpty(notFound);
    }
    public Mono<ServerResponse> updateBook(ServerRequest serverRequest)
    {
        Mono<Book> bookMono=serverRequest.bodyToMono(Book.class);
        return bookMono.flatMap(book ->
                ServerResponse.status(HttpStatus.CREATED).body(bookServiceImpl.updateBook(book), Book.class));
    }
    public Mono<ServerResponse> saveBook(ServerRequest serverRequest)
    {
        Mono<Book> booksaved=serverRequest.bodyToMono(Book.class);
        return booksaved.flatMap(book ->
                ServerResponse.status(HttpStatus.CREATED).body(bookServiceImpl.saveBook(book), Book.class));
    }
    public Mono<ServerResponse> deleteBook(ServerRequest serverRequest) {
        UUID uuid = UUID.fromString(serverRequest.pathVariable("uuid"));
        return this.bookServiceImpl.deleteBook(uuid).flatMap(result -> ServerResponse.accepted().build());
    }

}

