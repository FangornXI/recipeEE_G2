package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     //   String email = req.getParameter("emailAddress");
     //   String password = req.getParameter("password");
//
     //   String foundPassword = DaoFactory.getUserDAO().findPasswordByEmail(email);
//
     //   if (foundPassword != password){
     //       resp.sendRedirect(req.getContextPath() + "/login");
     //   }else{
     //
     //   }

        resp.sendRedirect(req.getContextPath() + "/homepage");
    }
}
