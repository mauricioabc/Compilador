/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany;

import com.compiler.Parser.gramaticaLRLexer;
import com.compiler.Parser.gramaticaLRParser;
import org.antlr.runtime.CharStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mauricio.rodrigues
 */
public class compiladorTestesLR {
    
    public compiladorTestesLR() {
    }

    @Test
    public void testaParser() throws IOException {
        String arquivo = "./exemplosLR/Exercicio_6.txt";
        // Cria um objeto FileReader a partir do arquivo de entrada
        FileReader fileReader = new FileReader(arquivo);

        // Cria um objeto BufferedReader a partir do FileReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Inicializa uma string que irá armazenar o código de entrada
        String codigo = "";

        // Lê cada linha do arquivo e adiciona à string de código
        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            codigo += linha + "\n";
        }

        // Fecha o BufferedReader e o FileReader
        bufferedReader.close();
        fileReader.close();

        // Fecha o BufferedReader e o FileReader
        bufferedReader.close();
        fileReader.close();

        // Cria um CharStream a partir da string de código
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString(codigo);
        // O restante do código é igual ao original
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        //CharStream input = CharStreams.fromString("main(){ int x, y; scanf(x); y = 3 * x; println(y); }");

        // Cria um CommonTokenStream a partir do lexer
        org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        org.antlr.v4.runtime.tree.ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));

    }

    
}
