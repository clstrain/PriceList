/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceList;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "menuPick")
@SessionScoped
public class MenuPick implements Serializable {
  
    private final String userName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    private final String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    private final String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    private final String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    private final String dbName = "plcls";
         
  /*
   private final String userName = "adminCBjUYQI";
     private final String password = "ESmteQ_Mm4BR";
     private final String host = "127.0.0.1";
     private final String port = "3306";
     private final String dbName = "plcls";
*/
    private final String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
    private static final long serialVersionUID = -5061581851476260511L;
    private Connection conn = null;
    private Statement stmt = null;
    private String response;

    public MenuPick() {
    }

    public List<String> getmenuItemsSuperProduct() {

        List<String> menuItemsSuperProduct = new ArrayList<String>() {
            private static final long serialVersionUID = 3109256773218160486L;

            {
                try {
                    //Connect to database

                    conn = DriverManager.getConnection(url, userName, password);

                    stmt = conn.createStatement();

                    ResultSet rset = null;

                    PreparedStatement pstmt = null;

                    pstmt = conn.prepareStatement("select distinct superProduct from"
                            + " Product order by superProduct asc");

                    rset = pstmt.executeQuery();

                    while (rset.next()) {
                        add(rset.getString("superProduct"));
                    }


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
            }
        };

        return menuItemsSuperProduct;
    }

    public List<String> getmenuItemsProduct() {

        List<String> menuItemsProduct = new ArrayList<String>() {
            private static final long serialVersionUID = 3109256773218160486L;

            {
                try {
                    //Connect to database

                    conn = DriverManager.getConnection(url, userName, password);

                    stmt = conn.createStatement();

                    ResultSet rset = null;

                    PreparedStatement pstmt = null;

                    pstmt = conn.prepareStatement("select distinct product from"
                            + " Product order by product asc");

                    rset = pstmt.executeQuery();

                    while (rset.next()) {
                        add(rset.getString("product"));
                    }


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
            }
        };

        return menuItemsProduct;
    }

    public List<String> getmenuItemsCourseType() {


        List<String> menuItemsCourseType = new ArrayList<String>() {
            private static final long serialVersionUID = 3109256773218160485L;

            {
                try {
                    //Connect to database                    

                    conn = DriverManager.getConnection(url, userName, password);

                    stmt = conn.createStatement();

                    ResultSet rset = null;

                    PreparedStatement pstmt = null;

                    pstmt = conn.prepareStatement("select distinct type from Course order by type asc");

                    rset = pstmt.executeQuery();

                    while (rset.next()) {
                        add(rset.getString("type"));
                    }


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
            }
        };
        return menuItemsCourseType;
    }

    public List<String> getmenuItemsCategory() {


        List<String> menuItemsCategory = new ArrayList<String>() {
            private static final long serialVersionUID = 3109256773218160485L;

            {
                try {
                    //Connect to database

                    conn = DriverManager.getConnection(url, userName, password);

                    stmt = conn.createStatement();

                    ResultSet rset = null;

                    PreparedStatement pstmt = null;

                    pstmt = conn.prepareStatement("select distinct category from Course order by category asc");



                    rset = pstmt.executeQuery();

                    while (rset.next()) {
                        add(rset.getString("category"));
                    }


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
            }
        };
        return menuItemsCategory;
    }

    public List<String> getmenuItemsLocation() {


        List<String> menuItemsLocation = new ArrayList<String>() {
            private static final long serialVersionUID = 3109256773218160485L;

            {
                try {
                    //Connect to database

                    conn = DriverManager.getConnection(url, userName, password);

                    stmt = conn.createStatement();

                    ResultSet rset = null;

                    PreparedStatement pstmt = null;

                    pstmt = conn.prepareStatement("select distinct location from Course order by location asc");

                    rset = pstmt.executeQuery();

                    while (rset.next()) {
                        add(rset.getString("location"));
                    }


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
            }
        };
        return menuItemsLocation;
    }
}