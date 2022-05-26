package br.edu.ifsul.testes.autor;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteRemoverAutor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            Autor a = em.find(Autor.class, 2);
            em.getTransaction().begin();
            em.remove(a);
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
