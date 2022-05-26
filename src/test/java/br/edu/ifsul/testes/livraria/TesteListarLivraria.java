/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.livraria;

import br.edu.ifsul.modelo.Livraria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteListarLivraria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        List<Livraria> lista = em.createQuery("from Livraria order by id").getResultList();
        for (Livraria l : lista) {
            System.out.println("ID: " + l.getId() + 
                    " | Nome: " + l.getNome() + 
                    " | Site: " + l.getSite());
        }

        em.close();
        emf.close();
    }
}
