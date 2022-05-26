/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.autor;

import br.edu.ifsul.modelo.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteListarAutor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        List<Autor> lista = em.createQuery("from Autor order by id").getResultList();
        for (Autor a : lista) {
            System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Bibliografia: " + a.getBibliografia());
        }

        em.close();
        emf.close();
    }
}
