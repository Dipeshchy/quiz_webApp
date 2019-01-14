package services;

import domain.Question;
import domain.Score;
import domain.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizServices {
    DatabaseConnection db = new DatabaseConnection();

    public Question getQuestion(int id) {
        String query = "select * from questions where id>? limit 1";
        Question question=null;
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question= new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrect_answer(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                question.setDifficulty_level(rs.getString("difficulty_level"));
            }        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public void calculateScore(User user,int id, String answer,String uniquegameid) {
        Question question = getQuestionForInsert(id);
        String query = "insert into score(uniquegameid,user,question,correct_answer,given_answer,result) values(?,?,?,?,?,?)";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,uniquegameid);
            pstm.setString(2,user.getUsername());
            pstm.setString(3,question.getQuestion());
            pstm.setString(4,question.getCorrect_answer());
            pstm.setString(5,answer);
            if (answer.equalsIgnoreCase(question.getCorrect_answer())) {
                pstm.setString(6,"Right");
            }
            else {
                pstm.setString(6,"Wrong");
            }
            pstm.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Question getQuestionForInsert(int id) {
        String query="select * from questions where id=?";
        Question question=null;
        PreparedStatement pstm1 = db.getPreparedStatement(query);
        try {
            pstm1.setInt(1,id);
            ResultSet rs = pstm1.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setQuestion(rs.getString("question"));
                question.setCorrect_answer(rs.getString("correct_answer"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public List<Score> getScore(User user,String uniquegameid) {
        Score score = null;
        List<Score> scoreList = new ArrayList<Score>();
        String query = "select * from score where user=? and uniquegameid=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,user.getUsername());
            pstm.setString(2,uniquegameid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                score = new Score();
                score.setUser(rs.getString("user"));
                score.setQuestion(rs.getString("question"));
                score.setCorrect_answer(rs.getString("correct_answer"));
                score.setGiven_answer(rs.getString("given_answer"));
                score.setResult(rs.getString("result"));
                scoreList.add(score);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return scoreList;
    }

    public int correctAnswer(User user,String uniquegameid) {
        int correctCount=0;
        String query = "select count(id) from score where user=? and uniquegameid=? and result=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,user.getUsername());
            pstm.setString(2,uniquegameid);
            pstm.setString(3,"Right");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                correctCount = rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return correctCount;
    }
}
