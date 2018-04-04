# WebFlux-Reactive-Cassandra
### Spring Webflux Framework with Spring Reactive Cassandra for making reactive application

### CQL Statements
```
CREATE KEYSPACE testspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

CREATE TABLE testspace.tblbook (
    book_id uuid PRIMARY KEY,
    book_author text,
    book_isbn text,
    book_pages int,
    book_title text
);
```
### Save Book
```
http.POST http://localhost:8080/book

{
        "book_id": "3fca62f3-53ba-4591-83d8-6236b616ad26",
        "book_title": "cassandra",
        "book_author": "Avinash Lakshman",
        "book_isbn": "148-5-11-199810-1",
        "book_pages": 255
}
```

### Get All Books
```
http.GET http://localhost:8080/book

```
### Find Book By Title (write title to path variable)
```
http.GET http://localhost:8080/book/{title}

```

### Update Book Base On book_id
```
http.PUT http://localhost:8080/book

{
        "book_id": "3fca62f3-53ba-4591-83d8-6236b616ad26",
        "book_title": "java",
        "book_author": "Lakshman",
        "book_isbn": "148-5-11-199810-1",
        "book_pages": 300
}
```

### Delete Book By book_id (write book_id as path variable)
```
http.DELETE http://localhost:8080/book/{book_id}

```
