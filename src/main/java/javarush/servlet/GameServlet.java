package javarush.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import javarush.Repository;
import javarush.logic.Game;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "GameServlet", urlPatterns = "/gameServlet")

public class GameServlet extends HttpServlet {
    private Game game;

    @Override
    public void init() throws ServletException {
        super.init();
        game = new Game(new Repository(), new ObjectMapper());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException {
        Integer stepID = Integer.parseInt(req.getParameter("stepID"));
        req.setAttribute("step", game.getStepById(stepID));
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}
