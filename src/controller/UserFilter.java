package controller;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String pageRequest = request.getParameter("pageRequest");
            User user = (User) session.getAttribute("user");

            if (pageRequest == null) {
                pageRequest = "NA";
            }

            if (pageRequest.equalsIgnoreCase("NA")) {
                if (user == null) {
                    redirectLogin(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                    rd.forward(request, response);
                }
            }

            if (!pageRequest.equalsIgnoreCase("login") && !pageRequest.equalsIgnoreCase("logout")) {
                if (user == null) {
                    redirectLogin(request, response);
                }
            }



        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private void redirectLogin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            request.setAttribute("msg", "Please Login!!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
    }

}
