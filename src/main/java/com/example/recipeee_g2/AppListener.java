package com.example.recipeee_g2;

import com.example.demo.dao.EMFManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------------- APP INITIALIZED ---------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------------- APP DESTROYED ---------------");
        EMFManager.closeEMF();
    }
}