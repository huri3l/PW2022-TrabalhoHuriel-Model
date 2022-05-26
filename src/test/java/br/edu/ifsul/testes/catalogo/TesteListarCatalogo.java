/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.catalogo;

import br.edu.ifsul.modelo.Catalogo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteListarCatalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        List<Catalogo> lista = em.createQuery("from Catalogo order by id").getResultList();
        for (Catalogo c : lista) {
            System.out.println("ID: " + c.getId() + 
                    " | Nome: " + c.getNome() + 
                    " | Livraria: " + c.getLivraria().getNome() +
                    " | Descrição: " + c.getDescricao());
        }

        em.close();
        emf.close();
    }
}
