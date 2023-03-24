package com.mycompany.compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    AnaliseLexica lexica = new AnaliseLexica();
    
    public void lerArquivo(File arquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        ArrayList<String[]> linhas = new ArrayList();
        String linhaAtual = leitor.readLine();
        while (linhaAtual != null) {
            //lexica.analisador(linhaAtual);
            linhaAtual = leitor.readLine();
        }
    }
    
    
}
    

