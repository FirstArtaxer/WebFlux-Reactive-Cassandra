package ardeshir.webfluxreactivecassandra.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("tblbook")
public class Book implements Serializable {
    @PrimaryKey
    private UUID book_id;
    @Column("book_title")
    private String book_title;
    @Column("book_author")
    private String book_author;
    @Column("book_isbn")
    private String book_isbn;
    @Column("book_pages")
    private Integer book_pages;


    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }


    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public Integer getBook_pages() {
        return book_pages;
    }

    public void setBook_pages(Integer book_pages) {
        this.book_pages = book_pages;
    }
}

