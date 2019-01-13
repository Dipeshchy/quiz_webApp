package controller;

import domain.Question;
import domain.User;
import services.QuestionServices;
import services.UserServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String pageRequest = request.getParameter("pageRequest");


        // for signup
        if(pageRequest.equalsIgnoreCase("signup")) {
            UserServices us = new UserServices();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            us.addUser(username,password);
            request.setAttribute("msg","Sign Up Success!!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }

        /**
         * to redirect to register page
         */
        if (pageRequest.equalsIgnoreCase("signuppage")) {
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request,response);
        }

        /**
         * for login
         */
        if (pageRequest.equalsIgnoreCase("login")) {
            UserServices us = new UserServices();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            User user = us.getUser(username,role,password);
            if (user != null) {

                    request.setAttribute("msg","Login Successful");
                    HttpSession session = request.getSession(false);
                    session.setAttribute("user",user);

                    RequestDispatcher rd = request.getRequestDispatcher("quiz/user/home.jsp");
                    rd.forward(request, response);

            }
            else {
                request.setAttribute("msg","Invalid Username or Password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }



        /**
         * for logout
         */
        if (pageRequest.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            request.setAttribute("msg","Logout Success!!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);

        }



        /**
         * to display the list of users
         */
        if (pageRequest.equalsIgnoreCase("userlist")) {
            getUserList(request,response);
        }

        /**
         * to redirect to admin home page
         */
        if (pageRequest.equalsIgnoreCase("home")) {
//            redirectLogin(request,response);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/user/home.jsp");
            rd.forward(request,response);
        }

        /**
         * to delete user
         */
        if (pageRequest.equalsIgnoreCase("delete")) {
            int userIdToDelete = Integer.parseInt(request.getParameter("id"));
            UserServices us = new UserServices();
            us.deleteUser(userIdToDelete);
            request.setAttribute("msg","Deleted");
            getUserList(request,response);
        }

        /**
         * to redirect to edit page
         */
        if (pageRequest.equalsIgnoreCase("edit")) {
//            redirectLogin(request,response);
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserServices().geteditUser(id);
            request.setAttribute("user",user);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/user/editUser.jsp");
            rd.forward(request,response);
        }

        /**
         * to update user
         */
        if (pageRequest.equalsIgnoreCase("update")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            int id = Integer.parseInt(request.getParameter("id"));
            UserServices us = new UserServices();
            us.updateuser(id,username,password,role);
            request.setAttribute("msg","Edited Successfully!!");
            getUserList(request,response);
        }



        /**
         * to begin play and go to next page
         */
        if (pageRequest.equalsIgnoreCase("letsplay")) {
//            redirectLogin(request,response);
        }

        /**
         * to redirect to profile page
         */
        if (pageRequest.equalsIgnoreCase("myprofile")) {
//            redirectLogin(request,response);
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserServices().getUserById(id);
            request.setAttribute("user",user);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/user/myprofile.jsp");
            rd.forward(request,response);
        }

        /**
         * to redirect to next page to choose game level and category
         */
        if(pageRequest.equalsIgnoreCase("letsplay")) {
//            redirectLogin(request,response);
            RequestDispatcher rd = request.getRequestDispatcher("quiz/user/choosegametype.jsp");
            rd.forward(request,response);
        }





    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    /**
     * method to get the list of users and list them
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    private void getUserList(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        redirectLogin(request,response);
        List<User> userList = new UserServices().getUserList();
        request.setAttribute("userlist",userList);
        RequestDispatcher rd = request.getRequestDispatcher("quiz/user/userlist.jsp");
        rd.forward(request,response);
    }

    /**
     * if session has expired,this will redirect to login page with session expired message
     */
//    private void redirectLogin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//    HttpSession session = request.getSession(false);
//        if (session.getAttribute("user") == null) {
//            request.setAttribute("msg", "Session Expired");
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//        }
//    }
}
