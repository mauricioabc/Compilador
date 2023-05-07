package com.mycompany;

import com.compiler.Parser.*;
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
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));

    }

    //Testes Aula 13 - Lista de Exercícios
    @Test
    public void testaExercicio_1(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("main(){ int x, y; scanf(x); y = 3 * x; println(y); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
    }
    
    @Test
    public void testaExercicio_2(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("main(){ int x; char y; scanf(x); y = 2 * x; println(y); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
    }
    
    @Test
    public void testaExercicio_3(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("int soma(int a, int b){ return a + b; } main(){ int x, y, z; x = 2; scanf(y); z = func soma(x,y); println(z); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
    }
    
    @Test
    public void testaExercicio_4(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("main(){ int x, y; scanf(x); y = 2 * x; println(y); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
    }
    
    @Test
    public void testaExercicio_5(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("main(){ int x; char y; scanf(x); y = 2 * x; println(y); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
    }
    
    @Test
    public void testaExercicio_6(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("int soma(int a, int b){ return a + b; } main(){ int x, y, z; x = 2; scanf(y); z = func soma(x,y); println(z); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        // Imprime a árvore de análise sintática
        System.out.println(tree.toStringTree(parser));
    }
    
    @Test
    public void testaExercicio_7(){
        org.antlr.v4.runtime.CharStream input = CharStreams.fromString("int soma(int a, int b){ return a + b; } main(){ int x, y, z; x = \"Dois\"; scanf(y); z = func soma(x,y); println(z); }");
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);
        
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
