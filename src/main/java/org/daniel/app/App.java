package org.daniel.app;

import org.daniel.util.MenuUtil;
import org.hibernate.HibernateException;

public class App {
    public static void main(String[] args) {
        try {
            MenuUtil.iniciarMenu();
        }catch (HibernateException e){
            System.err.println("Error de conexión con la base de datos.");
        }
    }
}