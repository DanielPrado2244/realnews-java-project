import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

// 
// Decompiled by Procyon v0.5.36
// 

public class CommentDAO
{
    public boolean createComment(final String username, final String comment) {
        boolean hasErrors = false;
        final Connection connex = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        if (username.isEmpty() || comment.isEmpty()) {
            return false;
        }
        try {
            stmt = connex.prepareStatement("insert into comentario (nome, texto, fk_noticia_id)\nvalues (?, ?, 1)");
            stmt.setString(1, username);
            stmt.setString(2, comment);
            stmt.executeUpdate();
            hasErrors = true;
            return hasErrors;
        }
        catch (SQLException ex) {
            System.out.println(ex);
            hasErrors = false;
            return hasErrors;
        }
        finally {
            ConnectionFactory.closeConnection(connex, stmt);
            return hasErrors;
        }
    }
    
    public List<Comment> getAllComments() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final List<Comment> comments = new ArrayList<Comment>();
        try {
            stmt = con.prepareStatement("SELECT * FROM comentario");
            rs = stmt.executeQuery();
            while (rs.next()) {
                final Comment comment = new Comment();
                comment.setUsername(rs.getString("nome"));
                comment.setComment(rs.getString("texto"));
                comments.add(comment);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return comments;
    }
}