package OneToOneRelationshipApplicationHB5.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
//This is my Fifth OneToOne relationship mapping Application
@Entity
@Table(name ="author")
public class Author {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name ="gen",strategy = "foreign",parameters = {@org.hibernate.annotations.Parameter(name = "property",value = "book")})
    private long id;
    private String author_firstname;
    private String author_lastname;
    private String author_address;
    private String author_email;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor_firstname() {
        return author_firstname;
    }

    public void setAuthor_firstname(String author_firstname) {
        this.author_firstname = author_firstname;
    }

    public String getAuthor_lastname() {
        return author_lastname;
    }

    public void setAuthor_lastname(String author_lastname) {
        this.author_lastname = author_lastname;
    }

    public String getAuthor_address() {
        return author_address;
    }

    public void setAuthor_address(String author_address) {
        this.author_address = author_address;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
