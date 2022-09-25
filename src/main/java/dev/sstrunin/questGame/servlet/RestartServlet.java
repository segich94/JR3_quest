package dev.sstrunin.questGame.servlet;

import dev.sstrunin.questGame.entity.User;
import dev.sstrunin.questGame.repository.StatisticService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "restartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {
    private StatisticService statisticService = new StatisticService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        user.setLevel(0);
        resp.sendRedirect("question");
    }
}
