/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author MATHEUS-NOTE
 */
public interface DAOInterface {
    
    public Long getId();
    public String[] getColunas();
    public Object[] toArray();
    public int[] getDefineRenderersColumn();
    public String getReferencia();
    public boolean validar();
    
}
