package com.mycompany.compilador;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.compilador.TabelaSimbolos;

public class AnaliseLexica {
    
    public static List<String> palavrasReservadas = new ArrayList<>();
    public static List<String> erros = new ArrayList<>();
    public static List<Simbolo> simbolos = new ArrayList<>();

    public AnaliseLexica() {
        palavrasReservadas.add("if");
    }
    

    public void analisador(String linha){
        
        int tamanhoLinha = linha.length();
        int posicaoAtual = 0;
        int estado = 0;
        char c;
        String lexema = "";
        String token;
        boolean volta = false;
        Simbolo sim;
        
        while(posicaoAtual != tamanhoLinha){
            c = linha.charAt(posicaoAtual);
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
                       lexema = ",";
                    }else if(c == ';'){
                       estado = 35;
                       lexema = ";";
                    }else if(c == '('){
                       estado = 36;
                       lexema = "(";
                    }else if(c == ')'){
                       estado = 37;
                       lexema = ")";
                    }else if(c == '['){
                       estado = 38;
                       lexema = "[";
                    }else if(c == ']'){
                       estado = 39;
                       lexema = "]";
                    }else if(c == '{'){
                       estado = 40;
                       lexema = "{";
                    }else if(c == '}'){
                       estado = 41;
                       lexema = "}";
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
                       volta = true;
                    }else{
                        estado = 42;
                        lexema += c;
                    }
                    break;
                case 2:
                    for (String palavraReservada : palavrasReservadas) {
                        if (palavraReservada.equals(lexema)) {
                            sim = new Simbolo(lexema, lexema);
                            simbolos.add(sim);
                        }
                        else {
                            int a = TabelaSimbolos.AutoIncrement.getNext();
                            sim = new Simbolo(lexema, "id", Integer.toString(a));
                            TabelaSimbolos.tabela.put(lexema, a);
                            simbolos.add(sim);
                            
                        }
                    }
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 3:
                    if(Character.isDigit(c)){
                        estado = 3;
                        lexema += c;
                    }else if(Character.isLetter(c)){
                        estado = 42;
                        lexema += c;
                    }else if(c == '.'){
                        estado = 5;
                        lexema += c;
                    }else if(!Character.isDigit(c)){
                        estado = 4;
                        volta = true;
                    }
                    break;
                case 4:
                    sim = new Simbolo(lexema, "NUM_INT", lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 5:
                    if(Character.isDigit(c)){
                        estado = 6;
                        lexema += c;
                    }else{
                        estado = 42;
                        lexema += c;
                    }
                    break;
                case 6:
                    if(Character.isDigit(c)){
                        estado = 6;
                        lexema += c;
                    }else if(Character.isLetter(c)){
                        estado = 42;
                        lexema += c;
                    }else if(!Character.isDigit(c)){
                        estado = 7;
                        volta = true;
                    }
                    break;
                case 7:
                    sim = new Simbolo(lexema, "NUM_DEC", lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 8:
                    if(c == '"'){
                        estado = 9;
                    }else if(c == '\n'){
                        estado = 42;
                        lexema += c; 
                    }else{
                        estado = 8;
                        lexema += c;
                    }
                    break;
                case 9:
                    sim = new Simbolo(lexema, "TEXTO", lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 10:
                    if(c == '/'){
                        estado = 11;
                        lexema += c;
                    }else {
                        estado = 13;
                        volta = true; 
                    }
                    break;
                case 11:
                    if(c == '\n'){
                        estado = 12;
                        lexema += c;
                    }else{
                        estado = 11;
                        lexema += c;
                    }
                    break;
                case 12:
                    sim = new Simbolo(lexema, "COMENT", lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 13:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 14,15,16,17:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 18:
                    if(c == '='){
                        estado = 19;
                        lexema += c;
                    }else {
                        estado = 20;
                        volta = true; 
                    }
                    break;
                case 19, 20:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 21:
                    if(c == '='){
                        estado = 22;
                        lexema += c;
                    }else {
                        estado = 23;
                        volta = true; 
                    }
                    break;
                case 22, 23:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 24:
                    if(c == '='){
                        estado = 25;
                        lexema += c;
                    }else {
                        estado = 26;
                        volta = true; 
                    }
                    break;
                case 25, 26:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 27:
                    if(c == '='){
                        estado = 28;
                        lexema += c;
                    }else {
                        estado = 29;
                        volta = true; 
                    }
                    break;
                case 28, 29:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 30:
                    if(c == '|'){
                        estado = 31;
                        lexema += c;
                    }else {
                        estado = 42;
                        lexema += c; 
                    }
                    break;
                case 31:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;   
                case 32:
                    if(c == '&'){
                        estado = 33;
                        lexema += c;
                    }else {
                        estado = 42;
                        lexema += c; 
                    }
                    break;
                case 33, 34, 35, 36, 37, 38, 39, 40, 41:
                    sim = new Simbolo(lexema, lexema);
                    simbolos.add(sim);
                    volta = false;
                    estado = 0;
                    lexema = "";
                    break;
                case 42:
                    erros.add(lexema);
                    break;
                default:
                    System.out.println("Default " +lexema);;
            }
            
            if(volta == false){
                posicaoAtual++;
            }
            
        }
        
    }
    
}
