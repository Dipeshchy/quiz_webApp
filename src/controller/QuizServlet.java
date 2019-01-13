package controller;

import domain.Question;
import domain.Score;
import domain.User;
import services.QuizServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRequest = request.getParameter("pageRequest");


        if (pageRequest.equalsIgnoreCase("playQuiz")) {
           getQuestion(request,response);
        }

        if (pageRequest.equalsIgnoreCase("nextQuestion")) {
            int id=Integer.parseInt(request.getParameter("id"));
            String answer = request.getParameter("answer");
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            new QuizServices().calculateScore(user,id,answer);
            getQuestion(request,response);
        }

        if (pageRequest.equalsIgnoreCase("viewResult")) {
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            List<Score> scoreList = new  QuizServices().getScore(user);
            request.setAttribute("scores",scoreList);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/game/score.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void getQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Question question = new QuizServices().getQuestion(id);
        request.setAttribute("question",question);
        RequestDispatcher rd = request.getRequestDispatcher("quiz/game/questions.jsp");
        rd.forward(request,response);
    }

}
