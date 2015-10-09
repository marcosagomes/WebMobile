/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.util;

/**
 *
 * @author Marcos
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

   

    private static EntityManager em;


    public static EntityManager getInstance() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("draftClientePU");
            em = emf.createEntityManager();
        }
        return em;
    }
}
