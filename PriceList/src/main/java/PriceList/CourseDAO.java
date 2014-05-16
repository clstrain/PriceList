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

public class CourseDAO implements Serializable {

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
     private final String port = "3306";
     private final String dbName = "plcls";
    
    private final String url = "jdbc:mysql://" + host + ":" + port + "/"
            + dbName;

     public CourseDAO() {
    }

    public List<CourseListing> getAll() {

        List<CourseListing> courseListing = new ArrayList<CourseListing>();

        try {
            //Connect to database

            conn = DriverManager.getConnection(url, userName, password);

            stmt = conn.createStatement();
            ResultSet rset = null, rset1 = null;

            PreparedStatement pstmt = null, pstmt1 = null;

            pstmt = conn.prepareStatement("select * FROM CourseProduct "
                    + "INNER JOIN Course "
                    + "ON CourseProduct.number=Course.number "
                    + "inner join Product "
                    + "on CourseProduct.P_ID=Product.P_ID "
                    + "group by Course.number");

           
            rset = pstmt.executeQuery();

            while (rset.next()) {

                String tempNumber = rset.getString("number");

                pstmt1 = conn.prepareStatement("select distinct product FROM "
                        + "CourseProduct INNER JOIN Course "
                        + "ON CourseProduct.number=Course.number "
                        + "inner join Product "
                        + "on CourseProduct.P_ID=Product.P_ID "
                        + "WHERE "
                        + "Course.number = ? order by product");

                pstmt1.setString(1, tempNumber);

                rset1 = pstmt1.executeQuery();

                String tempProduct = "";

                while (rset1.next()) {
                    tempProduct += " " + rset1.getString("product") + ",";
                }
                tempProduct = tempProduct.substring(0, tempProduct.length() - 1);

                courseListing.add(new CourseListing(
                        rset.getDouble("price"),
                        rset.getString("number"),
                        rset.getString("name"),
                        rset.getString("location"),
                        rset.getString("unit"),
                        rset.getString("duration"),
                        rset.getString("type"),
                        rset.getString("role"),
                        rset.getString("category"),
                        rset.getString("maxNumStudents"),
                        rset.getString("superProduct"),
                        rset.getString("subProduct"),
                        tempProduct));
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

    List<CourseListing> getByCategory(String selectedCategory, String selectedType) {

     List<CourseListing> courseListing = new ArrayList<CourseListing>();

    
        try {
            //Connect to database

            conn = DriverManager.getConnection(url, userName, password);

            stmt = conn.createStatement();
            ResultSet rset = null, rset1 = null;

            PreparedStatement pstmt = null, pstmt1 = null;

            pstmt = conn.prepareStatement("select * FROM CourseProduct "
                    + "INNER JOIN Course "
                    + "ON CourseProduct.number=Course.number "
                    + "inner join Product "
                    + "on CourseProduct.P_ID=Product.P_ID "
                    + "where (category = ? or ? ='') "
                    + "and (type = ? or ? ='') "
                    + "group by Course.number");

            pstmt.setString(1, selectedCategory);
            pstmt.setString(2, selectedCategory);
            pstmt.setString(3, selectedType);
            pstmt.setString(4, selectedType);
            
            rset = pstmt.executeQuery();

            while (rset.next()) {

                String tempNumber = rset.getString("number");

                pstmt1 = conn.prepareStatement("select distinct product FROM "
                        + "CourseProduct INNER JOIN Course "
                        + "ON CourseProduct.number=Course.number "
                        + "inner join Product "
                        + "on CourseProduct.P_ID=Product.P_ID "
                        + "WHERE "
                        + "Course.number = ? order by product");

                pstmt1.setString(1, tempNumber);

                rset1 = pstmt1.executeQuery();

                String tempProduct = "";

                while (rset1.next()) {
                    tempProduct += " " + rset1.getString("product") + ",";
                }
                tempProduct = tempProduct.substring(0, tempProduct.length() - 1);

                courseListing.add(new CourseListing(
                        rset.getDouble("price"),
                        rset.getString("number"),
                        rset.getString("name"),
                        rset.getString("location"),
                        rset.getString("unit"),
                        rset.getString("duration"),
                        rset.getString("type"),
                        rset.getString("role"),
                        rset.getString("category"),
                        rset.getString("maxNumStudents"),
                        rset.getString("superProduct"),
                        rset.getString("subProduct"),
                        tempProduct));
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
        
        this.response="Done";
        return courseListing;
    }

       
    
    
}
