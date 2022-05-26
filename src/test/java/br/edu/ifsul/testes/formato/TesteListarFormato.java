/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.formato;

import br.edu.ifsul.modelo.Formato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteListarFormato {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        List<Formato> lista = em.createQuery("from Formato order by id").getResultList();
        for (Formato f : lista) {
            System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome());
        }

        em.close();
        emf.close();
    }
}
