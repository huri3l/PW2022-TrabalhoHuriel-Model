package br.edu.ifsul.testes.autor;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Huriel Lopes
 */
public class TestePersistirAutor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Autor a = new Autor();
        a.setNome("Huriel Ferreira Lopes");
        a.setBibliografia("Humilde estudante de Ciências da Computação");
        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
