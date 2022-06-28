/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Livraria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hurie
 */
public class LivrariaRelatorio {
    public static List<Livraria> carregaLivrarias() {
        List<Livraria> lista = new ArrayList<>();
        
        Livraria l = new Livraria();
        
        l.setId(1);
        l.setNome("Delta");
        l.setSite("https://www.deltalivraria.com.br");
        
        lista.add(l);
        
        return lista;
    }
}
