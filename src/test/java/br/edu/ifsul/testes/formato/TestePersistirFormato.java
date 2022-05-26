package br.edu.ifsul.testes.formato;

import br.edu.ifsul.modelo.Formato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Huriel Lopes
 */
public class TestePersistirFormato {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Formato f = new Formato();
        f.setNome("Físico");
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
