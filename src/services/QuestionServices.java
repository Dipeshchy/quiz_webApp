package services;

import domain.Question;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionServices {
    DatabaseConnection db = new DatabaseConnection();

    /**
     * method to add questions
     */
    public void addQuestion(String question, String option1, String option2, String option3, String option4, String correct_answer, String category, String difficulty_level) {
        String query = "insert into questions(question,option1,option2,option3,option4,correct_answer,category,difficulty_level) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1, question);
            pstm.setString(2, option1);
            pstm.setString(3, option2);
            pstm.setString(4, option3);
            pstm.setString(5, option4);
            pstm.setString(6, correct_answer);
            pstm.setString(7, category);
            pstm.setString(8, difficulty_level);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to get list of all questions
     */
    public List<Question> getQuestionsList() {
        List<Question> questionsList = new ArrayList<Question>();
        Question question = null;
        String query="select * from questions";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrect_answer(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                question.setDifficulty_level(rs.getString("difficulty_level"));
                questionsList.add(question);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return questionsList;
    }

    /**
     * method to delete question
     */
    public void deleteQuestion(int id) {
        String query = "delete from questions where id=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            pstm.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to get details to edit question
     */
    public Question getQuestionDetailForEdit(int id) {
        String query = "select * from questions where id=?";
        Question question = null;
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrect_answer(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                question.setDifficulty_level(rs.getString("difficulty_level"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    /**
     * method to update questions
     */
    public void updateQuestion(int id,String question, String option1, String option2, String option3, String option4, String correct_answer, String category, String difficulty_level) {
        String query = "update questions set question=?,option1=?,option2=?,option3=?,option4=?,correct_answer=?,category=?,difficulty_level=? where id=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1, question);
            pstm.setString(2, option1);
            pstm.setString(3, option2);
            pstm.setString(4, option3);
            pstm.setString(5, option4);
            pstm.setString(6, correct_answer);
            pstm.setString(7, category);
            pstm.setString(8, difficulty_level);
            pstm.setInt(9,id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to get list of questions by category
     */
    public List<Question> getQuestionsListByCategory(String category) {
        List<Question> questionsList = new ArrayList<Question>();
        Question question = null;
        String query="select * from questions where category=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,category);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrect_answer(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                question.setDifficulty_level(rs.getString("difficulty_level"));
                questionsList.add(question);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return questionsList;
    }


    /**
     * method to get list of questions by difficulty level
     */
    public List<Question> getQuestionsListByDifficultyLevel(String difficulty_level) {
        List<Question> questionsList = new ArrayList<Question>();
        Question question = null;
        String query="select * from questions where difficulty_level=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,difficulty_level);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrect_answer(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                question.setDifficulty_level(rs.getString("difficulty_level"));
                questionsList.add(question);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return questionsList;
    }

    /**
     * method to get list of questions by category
     */
    public List<Question> getQuestionsByCategoryAndLevel(String category,String difficulty_level) {
        List<Question> questionsList = new ArrayList<Question>();
        Question question = null;
        String query;

        query = "select * from questions where category=? and difficulty_level=?";

        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,category);
            pstm.setString(2,difficulty_level);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrect_answer(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                question.setDifficulty_level(rs.getString("difficulty_level"));
                questionsList.add(question);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return questionsList;
    }



}

