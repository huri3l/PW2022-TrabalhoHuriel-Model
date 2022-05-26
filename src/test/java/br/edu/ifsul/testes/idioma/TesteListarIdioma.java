/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.idioma;

import br.edu.ifsul.modelo.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteListarIdioma {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        List<Idioma> lista = em.createQuery("from Idioma order by id").getResultList();
        for (Idioma i : lista) {
            System.out.println("ID: " + i.getId() + " | Nome: " + 
                    i.getNome() + 
                    " | Sigla: " + i.getSigla());
        }

        em.close();
        emf.close();
    }
}
