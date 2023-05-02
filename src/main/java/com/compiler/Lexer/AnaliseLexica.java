package com.compiler.Lexer;

import java.util.ArrayList;
import java.util.List;
import com.compiler.Lexer.TabelaSimbolos;

public class AnaliseLexica {
    
    public static List<String> palavrasReservadas = new ArrayList<>();
    public static List<String> erros = new ArrayList<>();
    public static List<Simbolo> simbolos = new ArrayList<>();

    public AnaliseLexica() {
        palavrasReservadas.add("int");
        palavrasReservadas.add("float");
        palavrasReservadas.add("char");
        palavrasReservadas.add("boolean");
        palavrasReservadas.add("void");
        palavrasReservadas.add("if");
        palavrasReservadas.add("else");
        palavrasReservadas.add("for");
        palavrasReservadas.add("while");
        palavrasReservadas.add("scanf");
        palavrasReservadas.add("println");
        palavrasReservadas.add("main");
        palavrasReservadas.add("return");
    }
    

    public void analisador(String linha, int numeroLinha){
        
        int tamanhoLinha = linha.length();
        int posicaoAtual = 0;
        int estado = 0;
        int ordem, autoIncrementNumber;
        char c;
        String lexema = "";
        String mensagemErro;
        boolean volta = false; 
        boolean status = false;
        Simbolo simbolo;
        
        while(posicaoAtual != tamanhoLinha){
            System.out.println("----------------------------------");
            System.out.println("Lendo posicao: " + posicaoAtual);
            System.out.println("Tamanho linha: " + tamanhoLinha);
            c = linha.charAt(posicaoAtual);
            
            System.out.println("Caractere lido: " + c);
            System.out.println("Lexama Inicio: " + lexema);
            System.out.println("Estado Inicio: " + estado);
            System.out.println("Volta Inicio: " + volta);
            
            switch (estado) {
                case 0:
                    volta = false;
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
                       lexema = "+";
                    }else if(c == '-'){
                       estado = 15;
                       lexema = "-";
                    }else if(c == '*'){
                       estado = 16;
                       lexema = "*";
                    }else if(c == '%'){
                       estado = 17;
                       lexema = "%";
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
                    }else if(c == ' '){
                       estado = 0;
                       lexema = "";
                    }else if(c == '\t'){
                       estado = 0;
                       lexema = "";
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
                    if (palavrasReservadas.contains(lexema)) {
                        simbolo = new Simbolo(lexema, lexema);
                        simbolos.add(simbolo);
                    }
                    else {
                        if (TabelaSimbolos.tabela.containsValue(lexema)) {
                            ordem = TabelaSimbolos.tabela.size();
                            for (int i = 1; i <= ordem; i++) {
                                if (lexema.equals(TabelaSimbolos.tabela.get(i))) {
                                    simbolo = new Simbolo(lexema, "id", Integer.toString(i));
                                    simbolos.add(simbolo);
                                }
                            }
                        } else {
                            autoIncrementNumber = TabelaSimbolos.AutoIncrement.getNext();
                            simbolo = new Simbolo(lexema, "id", Integer.toString(autoIncrementNumber));
                            TabelaSimbolos.tabela.put(autoIncrementNumber, lexema);
                            simbolos.add(simbolo);
                        }
                    }
                    volta = true;
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
                    simbolo = new Simbolo(lexema, "NUM_INT", lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, "NUM_DEC", lexema);
                    simbolos.add(simbolo);
                    volta = true;
                    estado = 0;
                    lexema = "";
                    break;
                case 8:
                    if(c == '"'){
                        estado = 9;
                    }else if(posicaoAtual + 1 == tamanhoLinha){
                        estado = 42;
                        lexema += c; 
                    }else{
                        estado = 8;
                        lexema += c;
                    }
                    break;
                case 9:
                    simbolo = new Simbolo(lexema, "TEXTO", lexema);
                    simbolos.add(simbolo);
                    volta = true;
                    estado = 0;
                    lexema = "";
                    break;
                case 10:
                    if(c == '/'){
                        estado = 11;
                        lexema += c;
                    }else if (c == 't'){
                        estado = 0;
                        lexema = "";
                    } else {
                        estado = 13;
                    }
                    break;
                case 11:
                    if(posicaoAtual + 1 == tamanhoLinha){
                        estado = 12;
                        lexema += c;
                    }else{
                        estado = 11;
                        lexema += c;
                    }
                    break;
                case 12:
                    simbolo = new Simbolo(lexema, "COMENT", lexema);
                    simbolos.add(simbolo);
                    volta = true;
                    estado = 0;
                    lexema = "";
                    break;
                case 13:
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
                    estado = 0;
                    lexema = "";
                    break;
                case 14,15,16,17:
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
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
                    simbolo = new Simbolo(lexema, lexema);
                    simbolos.add(simbolo);
                    volta = true;
                    estado = 0;
                    lexema = "";
                    break;
                case 42:
                    mensagemErro = "Linha: " + numeroLinha + " - Entrada inválida: '" + lexema + "'.";
                    erros.add(mensagemErro);
                    estado = 0;
                    lexema = "";
                    volta = true;
                    break;
                default:
                    System.out.println("Default " +lexema);;
            }
            
            if(volta == false){
                posicaoAtual++;
            }
            
            System.out.println("Lexama Fim: " + lexema);
            System.out.println("Estado Fim: " + estado);
            System.out.println("Volta Fim: " + volta);
            
            if (posicaoAtual == tamanhoLinha) {
                posicaoAtual = tamanhoLinha;
                System.out.println("Posicao atual igual ao tamanho.");
                if (status == false) {
                    System.out.println("Retorna 1 para garantir a verificacao do ultimo caractere.");
                    posicaoAtual--;
                    status = true;
                } 
            }
            
        }
        
    }
    
}
