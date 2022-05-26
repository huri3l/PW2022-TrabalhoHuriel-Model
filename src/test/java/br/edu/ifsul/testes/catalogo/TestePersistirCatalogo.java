/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.catalogo;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TestePersistirCatalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Catalogo c = new Catalogo();
        c.setNome("Livros de Sociologia");
        c.setDescricao("Contém informações como: título, autor(es), editora, "
                + "assunto, preço, ISBN, informações complementares, sinopse... "
                + "A respeito de livros de sociologia");
        Livraria l = em.find(Livraria.class, 1);
        c.setLivraria(l);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
