package com.mycompany;

import com.mycompany.compilador.AnaliseLexica;
import com.mycompany.compilador.Simbolo;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class compiladorTestes {
    
    public String testeLinha1 = "public static void main (String [] args){";
    public String testeLinha2 = "/tint a = 10, b = 4;";
    public String testeLinha3 = "/tfloat c = a / b;";
    public String testeLinha4 = "/tSystem.out.print(c);";
    public String testeLinha5 = "}";
    
    @Test
    public void testaLinha1AnalisadorLexico(){
        
        AnaliseLexica lex = new AnaliseLexica();
        lex.analisador(testeLinha1, 1);
        
        System.out.println("--- Lista gerada ---");
        for (Simbolo s : AnaliseLexica.simbolos) {
            System.out.println("Lexema: " + s.getLexema());
            System.out.println("Token: " + s.getToken());
        }    
    }
    
    @Test
    public void testaLinha2AnalisadorLexico(){
        
        AnaliseLexica lex = new AnaliseLexica();
        lex.analisador(testeLinha2, 2);
        
        System.out.println("--- Lista gerada ---");
        for (Simbolo s : AnaliseLexica.simbolos) {
            System.out.println("Lexema: " + s.getLexema());
            System.out.println("Token: " + s.getToken());
        }    
    }
    
    @Test
    public void testaLinha3AnalisadorLexico(){
        
        AnaliseLexica lex = new AnaliseLexica();
        lex.analisador(testeLinha3, 3);
        
        System.out.println("--- Lista gerada ---");
        for (Simbolo s : AnaliseLexica.simbolos) {
            System.out.println("Lexema: " + s.getLexema());
            System.out.println("Token: " + s.getToken());
        }    
    }
    
    @Test
    public void testaLinha4AnalisadorLexico(){
        
        AnaliseLexica lex = new AnaliseLexica();
        lex.analisador(testeLinha4, 4);
        
        System.out.println("--- Lista gerada ---");
        for (Simbolo s : AnaliseLexica.simbolos) {
            System.out.println("Lexema: " + s.getLexema());
            System.out.println("Token: " + s.getToken());
        }  
        
        System.out.println("--- Erros Encontrados ---");
        for (String s : AnaliseLexica.erros) {
            System.out.println("Erro Encontrado: " + s);
        }  
    }
    
    @Test
    public void testaLinha5AnalisadorLexico(){
        
        AnaliseLexica lex = new AnaliseLexica();
        lex.analisador(testeLinha5, 5);
        
        System.out.println("--- Lista gerada ---");
        for (Simbolo s : AnaliseLexica.simbolos) {
            System.out.println("Lexema: " + s.getLexema());
            System.out.println("Token: " + s.getToken());
        }    
    }
    
}
