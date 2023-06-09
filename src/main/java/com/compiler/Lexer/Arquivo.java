package com.compiler.Lexer;

import com.compiler.Parser.ErrorListener;
import com.compiler.Parser.gramaticaLRLexer;
import com.compiler.Parser.gramaticaLRParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Arquivo {

    AnaliseLexica lexica = new AnaliseLexica();
    public static String generatedTree;
    public static List<String> errors;
    
    public void lerArquivo(File arquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String codigo = "";
        String linhaAtual = leitor.readLine();
        int numeroLinha = 1;
        while (linhaAtual != null) {
            System.out.println("Linha a ser analisada:" + linhaAtual);
            lexica.analisador(linhaAtual, numeroLinha);
            codigo += linhaAtual + "\n";
            numeroLinha++;
            linhaAtual = leitor.readLine();
        }
        
        // Fecha o BufferedReader
        leitor.close();

        // Cria um CharStream a partir da string de código
        CharStream input = CharStreams.fromString(codigo);
        
        // Cria um lexer a partir do CharStream
        gramaticaLRLexer lexer = new gramaticaLRLexer(input);

        // Cria um CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Cria um parser a partir do CommonTokenStream
        gramaticaLRParser parser = new gramaticaLRParser(tokens);
        
        ErrorListener errorListener = new ErrorListener();
        parser.removeErrorListeners(); // Remove os listeners padrão do parser
        parser.addErrorListener(errorListener); // Adiciona o MeuErrorListener ao parser

        // Cria a árvore de análise sintática a partir do parser
        ParseTree tree = parser.programa();
        
        errors = errorListener.getErrors(); // Recupera as mensagens de erro geradas

        // Imprime a árvore de análise sintática
        generatedTree = tree.toStringTree(parser);
        
    }
    
}