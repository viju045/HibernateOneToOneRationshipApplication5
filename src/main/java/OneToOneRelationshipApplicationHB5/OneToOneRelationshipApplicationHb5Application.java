package OneToOneRelationshipApplicationHB5;


import OneToOneRelationshipApplicationHB5.model.Author;
import OneToOneRelationshipApplicationHB5.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneRelationshipApplicationHb5Application {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tsx = session.beginTransaction();

		Author a1 = new Author();
		a1.setAuthor_firstname("vijay");
		a1.setAuthor_lastname("Mohite");
		a1.setAuthor_address("pune");
		a1.setAuthor_email("vijay@gmail.com");

		Book b1 = new Book();
		b1.setBook_name("C++");
		b1.setBook_number(123);
		b1.setBook_price(1000);

		a1.setBook(b1);
		b1.setAuthor(a1);

		session.persist(a1);
		tsx.commit();

		session.close();
		System.out.println("Successful Done");

	}

}
