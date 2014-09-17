package PriceList;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CertDAO implements Serializable {

    public String response;
    private Connection conn = null;
    private Statement stmt = null;
    private CallableStatement cstmt = null;
    /*
     private final String userName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
     private final String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
     private final String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
     private final String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
     private final String dbName = "plcls";
     */

    private final String userName = "adminZfLaJBu";
    private final String password = "2y8aFmfFilmV";
    private final String host = "localhost";
    private final String port = "3307";
    private final String dbName = "plcls";

    private final String url = "jdbc:mysql://" + host + ":" + port + "/"
            + dbName;

    public CertDAO() {
    }

    public List<CertListing> getAll() {

        List<CertListing> courseListing = new ArrayList<CertListing>();

        try {
            //Connect to database

            conn = DriverManager.getConnection(url, userName, password);

            stmt = conn.createStatement();
            ResultSet rset = null;

            PreparedStatement pstmt = null;

            pstmt = conn.prepareStatement("select * FROM Certification group by Certification.number");

            rset = pstmt.executeQuery();

            while (rset.next()) {
                courseListing.add(new CertListing(
                        rset.getDouble("price"),
                        rset.getString("number"),
                        rset.getString("name"),
                        rset.getString("location"),
                        rset.getString("unit"),
                        rset.getString("duration"),
                        rset.getString("type"),
                        rset.getString("level"),
                        rset.getString("category"),
                        rset.getString("maxNumStudents"),
                        rset.getString("program")
                ));
            }
            this.response = "Searched";

        } catch (SQLException e) {
            response = "SQLException: " + e.getMessage();
            while ((e = e.getNextException()) != null) {
                response = e.getMessage();
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                response = "SQLException: " + e.getMessage();
                while ((e = e.getNextException()) != null) {
                    response = e.getMessage();
                }
            }
        }
        return courseListing;

    }

}
