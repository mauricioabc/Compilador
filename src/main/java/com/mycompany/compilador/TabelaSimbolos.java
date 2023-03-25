package com.mycompany.compilador;

import java.util.HashMap;

public class TabelaSimbolos {

    public static HashMap<Integer, String> tabela = new HashMap<>();

    public TabelaSimbolos() {
        
    }
    
    public class AutoIncrement {
        private static int count = 0;
    
        public static int getNext() {
            return ++count;
        }
    }
    
}
