package com.mycompany.compilador;

import java.util.ArrayList;
import java.util.List;

public class AnaliseLexica {
    
    List<String> palavrasReservadas = new ArrayList<>();
    List<String> erros = new ArrayList<>();

    public AnaliseLexica() {
        
    }
    

    public void analisador(String linha){
        
        int tamanhoLinha = linha.length();
        int posicaoAtual = 0;
        int estado = 0;
        char c;
        String lexema = "";
        String token;
        boolean volta = false;
        
        
        while(posicaoAtual != tamanhoLinha){
//            if(volta == false){
                c = linha.charAt(posicaoAtual);
//            }else{
//                c = linha.charAt(posicaoAtual-1);
//            }
            switch (estado) {
                case 0:
                    if(Character.isLetter(c) || c == '_'){
                       estado = 1;
                       lexema += c; 
                    }else if(Character.isDigit(c)){
                        estado = 3;
                       lexema += c;
                    }else if(c == '"'){
                       estado = 8;
                       lexema += c;
                    }else if(c == '/'){
                       estado = 10;
                       lexema += c;
                    }else if(c == '+'){
                       estado = 14;
                       token = "+";
                    }else if(c == '-'){
                       estado = 15;
                       token = "-";
                    }else if(c == '*'){
                       estado = 16;
                       token = "*";
                    }else if(c == '%'){
                       estado = 17;
                       token = "%";
                    }else if(c == '='){
                       estado = 18;
                       lexema += c;
                    }else if(c == '!'){
                       estado = 21;
                       lexema += c;
                    }else if(c == '>'){
                       estado = 24;
                       lexema += c;
                    }else if(c == '<'){
                       estado = 27;
                       lexema += c;
                    }else if(c == '|'){
                       estado = 30;
                       lexema += c;
                    }else if(c == '&'){
                       estado = 32;
                       lexema += c;
                    }else if(c == ','){
                       estado = 34;
                       token = ",";
                    }else if(c == ';'){
                       estado = 35;
                       token = ";";
                    }else if(c == '('){
                       estado = 36;
                       token = "(";
                    }else if(c == ')'){
                       estado = 37;
                       token = ")";
                    }else if(c == '['){
                       estado = 38;
                       token = "[";
                    }else if(c == ']'){
                       estado = 39;
                       token = "]";
                    }else if(c == '{'){
                       estado = 40;
                       token = "{";
                    }else if(c == '}'){
                       estado = 41;
                       token = "}";
                    }else{
                        estado = 42;
                        lexema += c;
                    }
                    break;
                case 1:
                    if(Character.isLetter(c) || c == '_' || Character.isDigit(c)){
                       estado = 1;
                       lexema += c; 
                    }else if(!Character.isLetter(c) || c != '_' || !Character.isDigit(c)){
                       estado = 2;
                       token = lexema;
                    }else{
                        estado = 42;
                        lexema += c;
                    }
                    break;
                case 42:
                    System.out.println("Erro "+lexema);
                default:
                    System.out.println("Defaut " +lexema);;
            }
            
        }
        
    }
    
}
