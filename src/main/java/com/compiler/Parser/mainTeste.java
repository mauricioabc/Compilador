package com.compiler.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author mauricio.rodrigues
 */
public class mainTeste {
    
    public static void main(String[] args) throws IOException {
        
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
        CharStream input = CharStreams.fromString(codigo);
        // O restante do código é igual ao original
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        //CharStream input = CharStreams.fromString("main(){ int x, y; scanf(x); y = 3 * x; println(y); }");

        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
        
    }
    
}
