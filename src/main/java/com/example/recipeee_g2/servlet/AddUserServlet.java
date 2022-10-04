package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/addUserForm.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String photoUrl = req.getParameter("photoUrl");
        String emailAddress = req.getParameter("emailAddress");
        String password = req.getParameter("password");


        DaoFactory.getUserDAO().create(new UserEntity());

    }
}
