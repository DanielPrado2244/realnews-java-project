import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// 
// Decompiled by Procyon v0.5.36
// 

@WebServlet(name = "Comments", urlPatterns = { "/RealNewsController" })
public class RealNewsController extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String action = request.getParameter("action");
        String forward = "";
        final CommentDAO dao = new CommentDAO();
        System.out.println("TESTE");
        final String s = action;
        switch (s) {
            case "real_news_view": {
                forward = "/RealNewsView.jsp";
                request.setAttribute("comments", (Object)dao.getAllComments());
                break;
            }
        }
        final RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward((ServletRequest)request, (ServletResponse)response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
    
    public String getServletInfo() {
        return "Short description";
    }
}
