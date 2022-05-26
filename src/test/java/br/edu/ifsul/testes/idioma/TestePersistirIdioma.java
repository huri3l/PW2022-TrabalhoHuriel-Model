/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.idioma;

import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TestePersistirIdioma {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Idioma i = new Idioma();
        i.setNome("Português Brasileiro");
        i.setSigla("PT-BR");
        
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
