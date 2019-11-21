package busnesslogic;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Anton on 08.09.2018.
 */
public class RootService {

    @Resource(lookup = "dbpool")
    private DataSource dataSource;


    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String index;
    String author;
    String title;
    Book book;

    public RootService() throws NamingException {
    }


    public Book getBooks() throws SQLException {

        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                index = rs.getString(1);
            author = rs.getString(2);
            title = rs.getString(3);
            }
            System.out.println("Book id: "+index+
            "Author: "+author+
            "Title: "+title);

        } catch (SQLException e) {
            System.out.println("FAILED CONNECTION");
        } finally {
            rs.close();
            stmt.close();
            conn.close();

        }
        return book = new Book(Integer.parseInt(index), author, title);

//        return database.getBook();
//    return null;
    }
}
