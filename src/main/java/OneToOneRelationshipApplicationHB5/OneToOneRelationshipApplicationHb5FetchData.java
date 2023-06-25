package OneToOneRelationshipApplicationHB5;

import OneToOneRelationshipApplicationHB5.model.Author;
import OneToOneRelationshipApplicationHB5.model.Book;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToOneRelationshipApplicationHb5FetchData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("from Author author");
        List<Author>list = query.getResultList();
        Iterator<Author>iterator = list.listIterator();

        while (iterator.hasNext())
        {
            Author a2 = iterator.next();
            System.out.println(a2.getAuthor_firstname()+ " "+a2.getAuthor_lastname()+" "+a2.getAuthor_address()+" "+a2.getAuthor_email());

            Book b2 = a2.getBook();
            System.out.println(b2.getBook_name()+" "+b2.getBook_number()+" "+b2.getBook_price());
        }
        session.close();
        System.out.println("Data Fetch successful");

    }
}
