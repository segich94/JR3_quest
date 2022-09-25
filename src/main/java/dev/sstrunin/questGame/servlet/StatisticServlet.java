package dev.sstrunin.questGame.servlet;

import dev.sstrunin.questGame.entity.User;
import dev.sstrunin.questGame.repository.StatisticService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "statisticServlet", value = "/statistic")
public class StatisticServlet extends HttpServlet {
    private StatisticService statisticService = new StatisticService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");

        req.getSession().setAttribute("win", statisticService.winCount(user));
        req.getSession().setAttribute("lose", statisticService.loseCount(user));
        req.getSession().setAttribute("attempts", statisticService.countOfAttempt(user));
    }
}
