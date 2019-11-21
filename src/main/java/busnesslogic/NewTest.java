package busnesslogic;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;

/**
 * Created by Anton on 09.09.2018.
 */
public class NewTest {
    public static void main(String[] args) {
        Book book=null;
        PersistenceProvider pp = new HibernatePersistenceProvider();
        EntityManagerFactory factory = pp.createEntityManagerFactory(
                "NewPersistenceUnit", new HashMap());
        EntityManager entity = factory.createEntityManager();
        entity.getTransaction().begin();
        System.out.println("Start transaction");
        book = entity.find(Book.class, 1);
        System.out.println("Author: "+book.getAuthor());
        entity.getTransaction().commit();
        entity.close();
        factory.close();
    }
}
