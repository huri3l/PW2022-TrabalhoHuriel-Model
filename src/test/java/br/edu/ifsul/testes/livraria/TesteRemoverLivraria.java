/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.livraria;

import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteRemoverLivraria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            Livraria l = em.find(Livraria.class, 2);
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } catch(Exception e) {
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getCause().getCause().getCause().getMessage());
        }

        em.close();
        emf.close();
    }
}
