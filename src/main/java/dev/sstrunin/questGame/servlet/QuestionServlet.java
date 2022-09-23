package dev.sstrunin.questGame.servlet;

import dev.sstrunin.questGame.entity.Question;
import dev.sstrunin.questGame.entity.User;
import dev.sstrunin.questGame.repository.QuestionsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(QuestionServlet.class);
    private QuestionsRepository questionsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        questionsRepository = new QuestionsRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        int questionId = user.getLevel();
        Question question = questionsRepository.getQuestions().get(questionId);
        req.setAttribute("question", question.getQuestion());
        req.setAttribute("answer1", question.getAnswer1());
        req.setAttribute("answer2", question.getAnswer2());
        LOGGER.info("Question: {} User: {} Session: {}",question.getQuestion(),user,req.getSession());
        getServletContext().getRequestDispatcher("/question/question.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        User user = (User) req.getSession().getAttribute("user");

        int questionId = user.getLevel();
        Question question = questionsRepository.getQuestions().get(questionId);
        req.setAttribute("question", question.getQuestion());
        req.setAttribute("answer1", question.getAnswer1());
        req.setAttribute("answer2", question.getAnswer2());


    }
}
