/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serviços;

/**
 *
 * @author AndreLucas
 */
public class ValidaCPF{ 
    
    int     d1, d2;            
    int     digito1, digito2, resto;            
    int     digitoCPF;            
    String  nDigResult;
    String  s_aux;

    public boolean validar(String s) {
        
        if (s.equals("999.999.999-99") || s.equals("   .   .   -  ")) {
            return false;
        }
        
        
        s_aux = s;
        s_aux = s_aux.replace(".", "");
        s_aux = s_aux.replace("-", "");
        
        d1 = d2 = 0;            
        digito1 = digito2 = resto = 0;            
        
        for (int n_Count = 1; n_Count < s_aux.length() -1; n_Count++){               
            digitoCPF = Integer.valueOf (s_aux.substring(n_Count -1, n_Count)).intValue();
            d1 = d1 + ( 11 - n_Count ) * digitoCPF; 
            d2 = d2 + ( 12 - n_Count ) * digitoCPF;            
        }
        
        resto = (d1 % 11);        
        if (resto < 2)               
            digito1 = 0;            
        else               
            digito1 = 11 - resto;
        d2 += 2 * digito1; 
        
        resto = (d2 % 11); 
        if (resto < 2)               
            digito2 = 0;            
        else               
            digito2 = 11 - resto;
        String nDigVerific = s_aux.substring (s_aux.length()-2, s_aux.length()); 
        
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2); 
        
        return nDigVerific.equals(nDigResult);         
    }
    
}