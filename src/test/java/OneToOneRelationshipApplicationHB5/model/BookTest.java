package OneToOneRelationshipApplicationHB5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class BookTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Book}
     *   <li>{@link Book#setAuthor(Author)}
     *   <li>{@link Book#setBook_name(String)}
     *   <li>{@link Book#setBook_number(int)}
     *   <li>{@link Book#setBook_price(int)}
     *   <li>{@link Book#setId(long)}
     *   <li>{@link Book#getAuthor()}
     *   <li>{@link Book#getBook_name()}
     *   <li>{@link Book#getBook_number()}
     *   <li>{@link Book#getBook_price()}
     *   <li>{@link Book#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Book actualBook = new Book();
        Book book = new Book();
        Author author = new Author();
        book.setAuthor(author);
        book.setBook_name("Book name");
        book.setBook_number(10);
        book.setBook_price(1);
        book.setId(1L);
        Author author2 = new Author();
        author2.setAuthor_address("42 Main St");
        author2.setAuthor_email("jane.doe@example.org");
        author2.setAuthor_firstname("Jane");
        author2.setAuthor_lastname("Doe");
        author2.setBook(book);
        author2.setId(1L);
        Book book2 = new Book();
        book2.setAuthor(author2);
        book2.setBook_name("Book name");
        book2.setBook_number(10);
        book2.setBook_price(1);
        book2.setId(1L);
        Author author3 = new Author();
        author3.setAuthor_address("42 Main St");
        author3.setAuthor_email("jane.doe@example.org");
        author3.setAuthor_firstname("Jane");
        author3.setAuthor_lastname("Doe");
        author3.setBook(book2);
        author3.setId(1L);
        actualBook.setAuthor(author3);
        actualBook.setBook_name("Book name");
        actualBook.setBook_number(10);
        actualBook.setBook_price(1);
        actualBook.setId(1L);
        Author author4 = actualBook.getAuthor();
        assertSame(author3, author4);
        Book book3 = author4.getBook();
        Author author5 = book3.getAuthor();
        assertSame(author2, author5);
        Book book4 = author5.getBook();
        assertSame(author, book4.getAuthor());
        assertEquals("Book name", actualBook.getBook_name());
        assertEquals("Book name", book3.getBook_name());
        assertEquals("Book name", book4.getBook_name());
        assertEquals(10, actualBook.getBook_number());
        assertEquals(10, book3.getBook_number());
        assertEquals(10, book4.getBook_number());
        assertEquals(1, actualBook.getBook_price());
        assertEquals(1, book3.getBook_price());
        assertEquals(1, book4.getBook_price());
        assertEquals(1L, actualBook.getId());
        assertEquals(1L, book3.getId());
        assertEquals(1L, book4.getId());
    }
}

