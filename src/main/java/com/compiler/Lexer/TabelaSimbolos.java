package com.compiler.Lexer;

import java.util.HashMap;

public class TabelaSimbolos {

    public static HashMap<Integer, String> tabela = new HashMap<>();
    public static int count = 0;
    
    public TabelaSimbolos() {
        
    }
    
    public class AutoIncrement {
    
        public static int getNext() {
            return ++count;
        }
    }
    
}
