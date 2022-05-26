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
public class TestePersistirLivraria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Livraria l = new Livraria();
        l.setNome("Delta");
        l.setSite("https://www.livrariadelta.com.br/");
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
