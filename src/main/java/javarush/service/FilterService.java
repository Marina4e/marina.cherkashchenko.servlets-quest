package javarush.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class FilterService {
    public Map<String, String> sessionInfoMap(HttpServletRequest request) {
        HashMap<String, String> resultMap = new HashMap<>();
        HttpSession session = request.getSession();
        String servletPattern = "/gameServlet";
        if (request.getParameter("stepID") == null) {
            servletPattern = servletPattern + "?stepID=1";
        }
        resultMap.put("servletPattern", servletPattern);
        if (session.getAttribute("IP") == null) {
            resultMap.put("IP", request.getRemoteAddr());
        }
        if (session.getAttribute("name") == null) {
            resultMap.put("name", request.getParameter("userName"));
        } else resultMap.put("name", (String) session.getAttribute("name"));
        return resultMap;
    }
}
