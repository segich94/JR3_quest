package dev.sstrunin.questGame.servlet;

import dev.sstrunin.questGame.entity.User;
import dev.sstrunin.questGame.repository.StatisticService;
import dev.sstrunin.questGame.repository.UsersRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "initServlet", value = "/init")
public class InitServlet extends HttpServlet {
    private UsersRepository usersRepository;
    private StatisticService statisticService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        usersRepository = UsersRepository.getInstance();
        statisticService = new StatisticService();
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            resp.sendRedirect("question");
        }
        User user;
        if (usersRepository.isUsernameExist(username)) {
            user = usersRepository.getUserByName(username);
        } else {
            user = usersRepository.addUser(username);
            statisticService.addUserToStatistic(user);
        }
        session.setAttribute("user", user);
        resp.sendRedirect("question");
    }
}
