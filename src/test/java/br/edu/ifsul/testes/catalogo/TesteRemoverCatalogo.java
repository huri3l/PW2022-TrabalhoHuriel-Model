/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.catalogo;

import br.edu.ifsul.modelo.Catalogo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteRemoverCatalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            Catalogo c = em.find(Catalogo.class, 2);
            em.getTransaction().begin();
            em.remove(c);
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
