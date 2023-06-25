package OneToOneRelationshipApplicationHB5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class AuthorTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Author}
     *   <li>{@link Author#setAuthor_address(String)}
     *   <li>{@link Author#setAuthor_email(String)}
     *   <li>{@link Author#setAuthor_firstname(String)}
     *   <li>{@link Author#setAuthor_lastname(String)}
     *   <li>{@link Author#setBook(Book)}
     *   <li>{@link Author#setId(long)}
     *   <li>{@link Author#getAuthor_address()}
     *   <li>{@link Author#getBook()}
     *   <li>{@link Author#getAuthor_email()}
     *   <li>{@link Author#getAuthor_firstname()}
     *   <li>{@link Author#getAuthor_lastname()}
     *   <li>{@link Author#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Author actualAuthor = new Author();
        actualAuthor.setAuthor_address("42 Main St");
        actualAuthor.setAuthor_email("jane.doe@example.org");
        actualAuthor.setAuthor_firstname("Jane");
        actualAuthor.setAuthor_lastname("Doe");
        Author author = new Author();
        author.setAuthor_address("42 Main St");
        author.setAuthor_email("jane.doe@example.org");
        author.setAuthor_firstname("Jane");
        author.setAuthor_lastname("Doe");
        Book book = new Book();
        author.setBook(book);
        author.setId(1L);
        Book book2 = new Book();
        book2.setAuthor(author);
        book2.setBook_name("Book name");
        book2.setBook_number(10);
        book2.setBook_price(1);
        book2.setId(1L);
        Author author2 = new Author();
        author2.setAuthor_address("42 Main St");
        author2.setAuthor_email("jane.doe@example.org");
        author2.setAuthor_firstname("Jane");
        author2.setAuthor_lastname("Doe");
        author2.setBook(book2);
        author2.setId(1L);
        Book book3 = new Book();
        book3.setAuthor(author2);
        book3.setBook_name("Book name");
        book3.setBook_number(10);
        book3.setBook_price(1);
        book3.setId(1L);
        actualAuthor.setBook(book3);
        actualAuthor.setId(1L);
        assertEquals("42 Main St", actualAuthor.getAuthor_address());
        Book book4 = actualAuthor.getBook();
        Author author3 = book4.getAuthor();
        assertEquals("42 Main St", author3.getAuthor_address());
        Book book5 = author3.getBook();
        Author author4 = book5.getAuthor();
        assertEquals("42 Main St", author4.getAuthor_address());
        assertEquals("jane.doe@example.org", actualAuthor.getAuthor_email());
        assertEquals("jane.doe@example.org", author3.getAuthor_email());
        assertEquals("jane.doe@example.org", author4.getAuthor_email());
        assertEquals("Jane", actualAuthor.getAuthor_firstname());
        assertEquals("Jane", author3.getAuthor_firstname());
        assertEquals("Jane", author4.getAuthor_firstname());
        assertEquals("Doe", actualAuthor.getAuthor_lastname());
        assertEquals("Doe", author3.getAuthor_lastname());
        assertEquals("Doe", author4.getAuthor_lastname());
        assertSame(book3, book4);
        assertSame(book2, book5);
        assertSame(book, author4.getBook());
        assertEquals(1L, actualAuthor.getId());
        assertEquals(1L, author3.getId());
        assertEquals(1L, author4.getId());
    }
}

