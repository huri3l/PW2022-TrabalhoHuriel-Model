package br.edu.ifsul.testes.livro;

import br.edu.ifsul.modelo.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteRemoverLivro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            Livro l = em.find(Livro.class, "9788533302276");
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
