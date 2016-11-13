import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Alan on 11/1/2016.
 */

@SuppressWarnings("UtilityClass")
public class SQLiteJDBC
{
    public static void main( String args[] )
    {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            e.printStackTrace();
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
        }
    }
}

//org.hibernate:hibernate-core:5.2.4.Final
//goes in build.gradle file, adds to project dependencies