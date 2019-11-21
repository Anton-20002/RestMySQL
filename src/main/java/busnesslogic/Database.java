package busnesslogic;

import busnesslogic.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 07.09.2018.
 */

public class Database {
    Book book;

    private SessionFactory factory;
    private Session session;

    public Database(){

    }

    @PostConstruct
    public void init(){
        book = new Book();
        factory = new Configuration().configure().buildSessionFactory();
        session= factory.openSession();
        session.beginTransaction();
        book = session.get(Book.class, 1);

    }
    @PreDestroy
    public void finish(){
        session.close();
        factory.close();
    }

    public Book getBook() {
        return book;
    }


}
