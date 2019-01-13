package controller;

import domain.Question;
import services.QuestionServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String pageRequest = request.getParameter("pageRequest");

        /**
         * to display list of all questions
         */
        if (pageRequest.equalsIgnoreCase("questions")) {
            getQuestionList(request,response);
        }

        /**
         * method to redirect to page to add question
         */
        if (pageRequest.equalsIgnoreCase("addQuestionPage")) {
//            redirectLogin(request,response);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/questions/addQuestion.jsp");
            rd.forward(request,response);
        }

        /**
         * to add questions
         */
        if (pageRequest.equalsIgnoreCase("addQuestion")) {
//            redirectLogin(request,response);
            String question =request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correct_answer = request.getParameter("correct_answer");
            String category = request.getParameter("category");
            String difficulty_level = request.getParameter("difficulty_level");
            new QuestionServices().addQuestion(question,option1,option2,option3,option4,correct_answer,category,difficulty_level);
            request.setAttribute("msg","Question Added");
            getQuestionList(request,response);
        }

        /**
         * To delete question
         */
        if (pageRequest.equalsIgnoreCase("deleteQuestion")) {
//            redirectLogin(request,response);
            int id = Integer.parseInt(request.getParameter("id"));
            new QuestionServices().deleteQuestion(id);
            request.setAttribute("msg","Question Deleted!!");
            getQuestionList(request,response);
        }

        /**
         * To redirect to edit question page
         */
        if (pageRequest.equalsIgnoreCase("editQuestion")) {
//            redirectLogin(request,response);
            int id = Integer.parseInt(request.getParameter("id"));
            Question question = new QuestionServices().getQuestionDetailForEdit(id);
            request.setAttribute("question",question);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/questions/editQuestion.jsp");
            rd.forward(request,response);
        }

        /**
         * to update Question
         */
        if (pageRequest.equalsIgnoreCase("updateQuestion")) {
//            redirectLogin(request,response);
            int id = Integer.parseInt(request.getParameter("id"));
            String question =request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correct_answer = request.getParameter("correct_answer");
            String category = request.getParameter("category");
            String difficulty_level = request.getParameter("difficulty_level");
            new QuestionServices().updateQuestion(id,question,option1,option2,option3,option4,correct_answer,category,difficulty_level);
            request.setAttribute("msg","Question Updated!!");
            getQuestionList(request,response);
        }

        /**
         * For selecting question by category
         */
        if (pageRequest.equalsIgnoreCase("selectByCategory")) {
//            redirectLogin(request,response);
            String category = request.getParameter("selectedCategory");
            List<Question> questionList = new QuestionServices().getQuestionsListByCategory(category);
            request.setAttribute("questionList",questionList);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/questions/questionslist.jsp");
            rd.forward(request,response);

        }

        /**
         * For selecting question by difficulty level
         */
        if (pageRequest.equalsIgnoreCase("selectByDifficultyLevel")) {
//            redirectLogin(request,response);
            String difficulty_level = request.getParameter("selectedDifficultyLevel");
            List<Question> questionList = new QuestionServices().getQuestionsListByDifficultyLevel(difficulty_level);
            request.setAttribute("questionList",questionList);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/questions/questionslist.jsp");
            rd.forward(request,response);

        }

        /**
         * to choose the game type(category and difficulty level)
         */
        if (pageRequest.equalsIgnoreCase("gametype")) {
//            redirectLogin(request,response);
           String category = request.getParameter("category");
           String difficulty_level = request.getParameter("difficulty_level");
           List<Question> questionList;
           if (category.equalsIgnoreCase("all")) {
               questionList = new QuestionServices().getQuestionsListByDifficultyLevel(difficulty_level);
           }
           else {
               questionList = new QuestionServices().getQuestionsByCategoryAndLevel(category,difficulty_level);
            }
           request.setAttribute("questionList",questionList);
           RequestDispatcher rd = request.getRequestDispatcher("quiz/user/questions.jsp");
           rd.forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    protected void getQuestionList(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        redirectLogin(request,response);
        List<Question> questionList = new QuestionServices().getQuestionsList();
        request.setAttribute("questionList",questionList);
        RequestDispatcher rd = request.getRequestDispatcher("quiz/questions/questionslist.jsp");
        rd.forward(request,response);
    }

    /**
     * if session has expired,this will redirect to login page with session expired message
     */
//    private void redirectLogin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        if (session.getAttribute("user") == null) {
//            request.setAttribute("msg", "Session Expired");
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//        }
//    }
}
