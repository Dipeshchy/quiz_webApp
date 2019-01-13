package services;

import domain.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {
    DatabaseConnection db = new DatabaseConnection();

    /**
     * method to add new user
     */
    public void addUser(String username,String password) {
        String query = "insert into user(username,password,role) values(?,?,?)";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.setString(3,"player");
            pstm.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to get the user for login
     * @param username
     * @param role
     * @param password
     * @return
     */
    public User getUser(String username,String role,String password) {
        User user = null;
        String query = "select * from user where username=? and role=? and password=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,username);
            pstm.setString(2,role);
            pstm.setString(3,password);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * method to get the list of users to show in userlist
     * @return
     */
    public List<User> getUserList() {
        User user = null;
        List<User> userList = new ArrayList<User>();
        String query = "select * from user";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * method to delete user
     * @param id
     */
    public void deleteUser(int id) {
        User user = null;
        String query = "delete from user where id=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * method to get the user detail for edit
     * @param id
     * @return
     */
    public User geteditUser(int id) {
        User user = null;
        String query = "select * from user where id=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * method to update user
     * @param id
     * @param username
     * @param password
     * @param role
     */
    public void updateuser(int id,String username,String password,String role) {
        User uer = null;
        String query = "update user set username=?,password=?,role=? where id=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.setString(3,role);
            pstm.setInt(4,id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * method to get user by id
     */
    public User getUserById(int id) {
        User user = null;
        String query = "select * from user where id=?";
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
