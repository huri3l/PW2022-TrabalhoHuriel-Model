package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Huriel Lopes
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {
    
    @NotBlank(message = "O código de barras não pode ser em branco")
    @Length(max = 130, message = "O código de barras não pode ter mais que {max} caracteres")
    @Column(name = "codigo_barras", length = 130, nullable = false)
    private String codigoBarras;
    
    @NotNull(message = "O número de páginas deve ser informado")
    @Min(value = 1, message = "O livro deve ter no mínimo 1 página")
    @Column(name = "numero_paginas", nullable = false)
    private Integer numeroPaginas;
    
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada")
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    
    @NotNull(message = "O valor deve ser informado")
    @Min(value = 0, message = "O preço não pode ser menor que 0")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(6,2)")
    private Double valor;
    
    @NotNull(message = "O idioma deve ser informado")
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    private Idioma idioma;
    
    @NotNull(message = "O formato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    private Formato formato;
    
    @NotNull(message = "O catálogo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;
    
    public Livro() {

    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
}
