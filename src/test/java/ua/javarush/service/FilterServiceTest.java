package ua.javarush.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
 class FilterServiceTest {

    HttpServletRequest request = mock(HttpServletRequest.class);
    @Mock
    HttpSession session;

    @Test
    void sessionInfoMap_returnsPropInfoTest(){
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("stepID")).thenReturn("SomeID");
        Mockito.when(session.getAttribute("IP")).thenReturn("SomeIP");
        Map<String, String> stringStringMap = new FilterService().sessionInfoMap(request);
        assertAll("string",
                ()->assertNotEquals("/gameServlet?stepID=1", stringStringMap.get("servletPattern")),
                ()->assertNotEquals("0.0.0.0.0", stringStringMap.get("IP")));
    }

    @Test
    void sessionInfoMap_returnsPropInfo1Test(){
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("stepID")).thenReturn(null);
        Mockito.when(request.getRemoteAddr()).thenReturn("0.0.0.0.0");
        Mockito.when(session.getAttribute("IP")).thenReturn(null);
        Mockito.when(session.getAttribute("name")).thenReturn(null);
        Mockito.when(request.getParameter("userName")).thenReturn("Some_Name");


        Map<String, String> stringStringMap = new FilterService().sessionInfoMap(request);
        assertAll("string",
                ()->assertEquals("/gameServlet?stepID=1", stringStringMap.get("servletPattern")),
                ()->assertEquals("0.0.0.0.0", stringStringMap.get("IP")));
    }

    @Test
    void sessionInfoMap_returnsServletPatternTest(){
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("name")).thenReturn("Some_Name");
        Mockito.when(session.getAttribute("IP")).thenReturn(null);
        Map<String, String> stringStringMap = new FilterService().sessionInfoMap(request);
        assertEquals("Some_Name", stringStringMap.get("name"));
    }
}
