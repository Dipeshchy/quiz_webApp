package domain;

public class Score {
    private int id;
    private String uniqueGameId;
    private String user;
    private String question;
    private String correct_answer;
    private String given_answer;
    private String result;

    public String getUniqueGameId() {
        return uniqueGameId;
    }

    public void setUniqueGameId(String uniqueGameId) {
        this.uniqueGameId = uniqueGameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getGiven_answer() {
        return given_answer;
    }

    public void setGiven_answer(String given_answer) {
        this.given_answer = given_answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
