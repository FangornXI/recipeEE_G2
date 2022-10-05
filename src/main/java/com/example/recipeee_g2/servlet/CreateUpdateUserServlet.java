package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.CommentEntity;
import com.example.recipeee_g2.entity.CookedRecipeEntity;
import com.example.recipeee_g2.entity.RecipeEntity;
import com.example.recipeee_g2.entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@WebServlet({"/user/Create","/user/Update"})
public class CreateUpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null){
            req.setAttribute("user", null);
            req.setAttribute("type", "Create");
            req.getRequestDispatcher("/WEB-INF/createUpdateUserForm.jsp").forward(req,resp);
        }else{
            String idStr = req.getSession().getAttribute("user").toString();
            Optional<UserEntity> user = DaoFactory.getUserDAO().findById(Integer.parseInt(idStr));
            if (user.isPresent()) {
                req.setAttribute("user", user.get());
                req.setAttribute("type", "Update");
                req.getRequestDispatcher("/WEB-INF/createUpdateUserForm.jsp").forward(req,resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/homepage");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String photoUrl = req.getParameter("photoUrl");
        String emailAddress = req.getParameter("emailAddress");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

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

        if (type.equals("Update")){
            int id = Integer.parseInt(req.getSession().getAttribute("user").toString());
            String PassByID = DaoFactory.getUserDAO().findById(id).get().getPassword();
            if (password.equals("") || password.equals(PassByID)) {
                generatedPassword =  PassByID;
            }
            DaoFactory.getUserDAO().edit(new UserEntity(id, lastname, firstName, emailAddress, photoUrl, generatedPassword, null, null,null));
        }else{
            if(DaoFactory.getUserDAO().findByField("email",emailAddress).isEmpty()){
                DaoFactory.getUserDAO().create(new UserEntity(lastname, firstName, emailAddress, photoUrl, generatedPassword, null, null,null));
            }
        }

        resp.sendRedirect(req.getContextPath() + "/homepage");

    }
}
