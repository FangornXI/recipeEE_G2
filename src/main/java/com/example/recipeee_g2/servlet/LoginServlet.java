package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("emailAddress");
        String password = req.getParameter("password");
        String generatedPassword = null;
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        List<UserEntity> listUser= DaoFactory.getUserDAO().findByField("email",email);
        if (listUser.isEmpty()) {
            req.setAttribute("message", "Unknown login, please try again");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        } else if (listUser.get(0).getPassword().equals(generatedPassword)) {
            req.getSession().setAttribute("user",listUser.get(0).getId());
            resp.sendRedirect(req.getContextPath() + "/homepage");
        }else{
            req.setAttribute("message", "Unknown password, please try again");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
//        System.out.println(listUser);

    }
}
