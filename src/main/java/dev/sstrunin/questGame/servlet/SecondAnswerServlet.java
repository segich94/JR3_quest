package dev.sstrunin.questGame.servlet;

import dev.sstrunin.questGame.entity.Question;
import dev.sstrunin.questGame.entity.User;
import dev.sstrunin.questGame.repository.QuestionsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "secondAnswer", value = "/secondAnswer")
public class SecondAnswerServlet extends HttpServlet {
    QuestionsRepository questionsRepository = new QuestionsRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        int questionId = user.getLevel();
        Question question = questionsRepository.getQuestions().get(questionId);

        if (question.getId() == (questionsRepository.getQuestions().size() - 1)) {
            req.setAttribute("result", QuestionsRepository.WIN_GAME);
            getServletContext().getRequestDispatcher("/result/result.jsp").forward(req, resp);
        }

        if (questionsRepository.isCorrectAnswer(questionId, 1)) {
            user.setLevel(questionId + 1);
            resp.sendRedirect("question");
        } else {
            req.setAttribute("result", QuestionsRepository.LOSE_GAME);
            getServletContext().getRequestDispatcher("/result/result.jsp").forward(req, resp);
        }

    }
}
