/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serviços;

import java.util.GregorianCalendar;

/**
 *
 * @author AndreLucas
 */
public class ValidaData {
    
    public boolean validar(String s){
        GregorianCalendar calendar =  new GregorianCalendar();
        int dia = 0,mes = 0,ano = 0;
        String diaStr = s.substring(0,2);
        String mesStr = s.substring(3,5);
        String anoStr = s.substring(6,10);
        dia = Integer.parseInt(diaStr);
        mes = Integer.parseInt(mesStr);
        ano = Integer.parseInt(anoStr);

        if ((dia == 0) && (mes == 0) && (ano == 0)) {
            return true;
        } else {
            if (dia < 1 || mes < 1 || ano < 1)
                return false;
            else
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
                    if (dia <= 31)
                        return true;
                    else
                        return false;
                else
                    if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
                        if (dia <= 30)
                            return true;
                        else
                            return false;
                    else
                        if (mes == 2)
                            if (calendar.isLeapYear(ano))
                                if (dia <= 29)
                                    return true;
                                else
                                    return false;
                            else
                                if (dia <= 28)
                                    return true;
                                else
                                    return false;
                        else
                            if (mes > 12)
                                return false;

            return true;
        }
    }  
}
