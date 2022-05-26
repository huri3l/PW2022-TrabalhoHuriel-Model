package br.edu.ifsul.testes.formato;

import br.edu.ifsul.modelo.Formato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteRemoverFormato {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            Formato f = em.find(Formato.class, 2);
            em.getTransaction().begin();
            em.remove(f);
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
