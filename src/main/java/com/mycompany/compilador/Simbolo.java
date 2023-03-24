package com.mycompany.compilador;

public class Simbolo {

    private String lexema;
    private String token;
    private String atributo;

    public Simbolo(String lexema, String token, String atributo) {
        this.lexema = lexema;
        this.token = token;
        this.atributo = atributo;
    }

    public Simbolo(String lexema, String token) {
        this.lexema = lexema;
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public String getToken() {
        return token;
    }

    public String getAtributo() {
        return atributo;
    }
    
    
    
    
}
