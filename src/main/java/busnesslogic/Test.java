package busnesslogic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;

/**
 * Created by Anton on 07.09.2018.
 */
public class Test {
    private static final String USER = "root";
    private static final String PASSWORD = "372987316684azXY";
    private static final String CON_url = "jdbc:mysql://localhost:3306/resttest?useSSL=false";



    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(CON_url, USER, PASSWORD);
            System.out.println("Connected!");
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM books");
            while (rs.next()){
            String index = rs.getString(1);
            String author = rs.getString(1);
            String title = rs.getString(2);
            System.out.println(
                    "Book id: "+index+
                            " Author: "+author+
                            " Title: "+title
            );}
        } catch (SQLException e) {
            System.out.println("Failed connection...");
        } finally {
        }
        if(rs!=null){
            rs.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }





    }
}
