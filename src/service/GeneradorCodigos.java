package service;

import java.util.Random;

public class GeneradorCodigos {
    
    public String generarCodigo()
    {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 8; i++) 
        {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }

        return codigo.toString();        
    }   
}