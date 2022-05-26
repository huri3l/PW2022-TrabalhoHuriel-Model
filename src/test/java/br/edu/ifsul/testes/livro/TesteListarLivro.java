/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes.livro;

import br.edu.ifsul.modelo.Livro;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hurie
 */
public class TesteListarLivro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-TrabalhoHuriel-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd/MM/yyyy"
        );

        List<Livro> lista = em.createQuery("from Livro order by id").getResultList();
        for (Livro l : lista) {
            System.out.println("ISBN: " + l.getISBN() + 
                    " | Titulo: " + l.getTitulo() +
                    " | Editora: " + l.getEditora() +
                    " | Data de Publicacao: " + sdf.format(l.getDataPublicacao().getTime()) +
                    " | Resumo: " + l.getResumo() + 
                    " | Ativo: " + l.getAtivo() + 
                    " | Codigo de Barras: " + l.getCodigoBarras() +
                    " | Data de Cadastro: " + sdf.format(l.getDataCadastro().getTime()) +
                    " | Numero de Paginas: " + l.getNumeroPaginas() +
                    " | Valor: " + l.getValor() +
                    " | Catalogo: " + l.getCatalogo().getNome() +
                    " | Formato: " + l.getFormato().getNome() + 
                    " | Idioma: " + l.getIdioma().getNome()
            );
        }

        em.close();
        emf.close();
    }
}
