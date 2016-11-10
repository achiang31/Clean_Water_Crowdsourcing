import java.sql.*;

class SQLiteJDBC
{
    public static void main( String args[] )
    {
        @SuppressWarnings("UnusedAssignment") Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            //noinspection UnusedAssignment
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}

//org.hibernate:hibernate-core:5.2.4.Final
//goes in build.gradle file, adds to project dependencies