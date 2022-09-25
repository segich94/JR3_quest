package dev.sstrunin.questGame.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "startServlet", value = "/start")
public class StartServlet extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger(StartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Connect: session {}",req.getSession());
        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("start/start.jsp");
        requestDispatcher.forward(req, resp);


    }
}
