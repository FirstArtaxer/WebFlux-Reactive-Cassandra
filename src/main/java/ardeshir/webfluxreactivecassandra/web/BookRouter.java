package ardeshir.webfluxreactivecassandra.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(BookHandler bookHandler) {
        return nest(path("/book"),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(GET("/"), bookHandler::getAllBooks)
                                .andRoute(GET("/{title}"), bookHandler::getBookByTtile)
                                .andRoute(POST("/"), bookHandler::saveBook)
                                .andRoute(PUT("/"), bookHandler::updateBook)
                                .andRoute(DELETE("/{uuid}"), bookHandler::deleteBook)
                ));
    }
}
