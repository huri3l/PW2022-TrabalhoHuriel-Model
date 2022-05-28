package br.edu.ifsul.testes.livro;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Huriel Lopes
 */
public class TestePersistirLivro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Catalogo c = em.find(Catalogo.class, 1);
        Formato f = em.find(Formato.class, 1);
        Idioma i = em.find(Idioma.class, 1);
        Autor a = em.find(Autor.class, 1);
        
        Livro l = new Livro();
        l.setISBN("9788533302223");
        l.setDataPublicacao(Calendar.getInstance());
        l.setEditora("Intrinseca");
        l.setResumo("Misturando ciência, filosofia e tiradas inteligentes e "
                + "hilárias, Manson vai fazer você questionar suas crenças e "
                + "mudar de vida");
        l.setTitulo("F*deu Geral");
        l.setAtivo(true);
        l.setCodigoBarras("568754456745");
        l.setDataCadastro(Calendar.getInstance());
        l.setNumeroPaginas(286);
        l.setValor(29.09d);
        l.setCatalogo(c);
        l.setFormato(f);
        l.setIdioma(i);
        l.adicionarAutor(a);
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
