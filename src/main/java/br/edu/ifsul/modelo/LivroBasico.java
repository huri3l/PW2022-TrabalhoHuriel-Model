package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Huriel Lopes
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livro_basico")
public class LivroBasico implements Serializable {
    @Id
    @NotBlank(message = "O ISBN do livro deve ser informado")
    @Length(max = 13, message = "O ISBN não deve ter mais que {max} caracteres")
    @Column(name = "isbn", length = 13, nullable = false)
    private String ISBN;
    
    @NotBlank(message = "O título do livro deve ser informado")
    @Length(max = 40, message = "O título do livro não deve ter mais que {max} caracteres")
    @Column(name = "titulo", length = 40, nullable = false)
    private String titulo;
    
    @Length(max = 300, message = "O resumo do livro não deve ter mais que {max} caracteres")
    @Column(name = "resumo", length = 300, nullable = true)
    private String resumo;
    
    @NotBlank(message = "A editora deve ser informada")
    @Length(max = 40, message = "A editora não deve ter mais que {max} caracteres")
    @Column(name = "editora", length = 40, nullable = false)
    private String editora;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de publicação deve ser informada")
    @Column(name = "data_publicacao", nullable = false)
    private Calendar dataPublicacao;
    
    @ManyToMany
    @JoinTable(name = "livro_basico_autor",
            joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false)
    )
    
    private List<Autor> autores = new ArrayList<>();
    
    public LivroBasico() {
        
    }
    
    public void adicionarAutor(Autor obj) {
        this.getAutores().add(obj);
    }

    public void removerAutor(int index) {
        this.autores.remove(index);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        return Objects.equals(this.ISBN, other.ISBN);
    }
}
