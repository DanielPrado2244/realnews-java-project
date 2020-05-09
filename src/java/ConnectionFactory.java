import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

// 
// Decompiled by Procyon v0.5.36
// 

public class ConnectionFactory
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/portal_realnews";
    private static final String USER = "sysadmin";
    private static final String PASS = "@sysadmin1903";
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_realnews", "sysadmin", "@sysadmin1903");
        }
        catch (ClassNotFoundException | SQLException ex) {
            
            throw new RuntimeException("Erro na conex\u00e3o: ", ex);
        }
    }
    
    public static void closeConnection(final Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(final Connection con, final PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(final Connection con, final PreparedStatement stmt, final ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}