package ua.javarush.filter;

import ua.javarush.service.FilterService;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


@WebFilter(urlPatterns = "/gameServlet")
public class StartFilter extends HttpFilter {
    private final transient FilterService filterService = new FilterService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res,
                            FilterChain chain) throws IOException, ServletException {

        Map<String, String> sessionInfoParam = filterService.sessionInfoMap(req);
        HttpSession session = req.getSession();
        session.setAttribute("name", sessionInfoParam.get("name"));
        session.setAttribute("IP", sessionInfoParam.get("IP"));
        String servletPattern = sessionInfoParam.get("servletPattern");
        RequestDispatcher dispatcher = req.getRequestDispatcher(servletPattern);
        dispatcher.forward(req, res);
    }

    @Override
    public void destroy() {
        //left empty, indicating that no special actions are needed during destruction.
    }
}
