/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis;
import Persistencia.DAOInterface;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author jfilhogn
 */
public class JPanelGrid extends JTable{
    
    public JPanelGrid(List l) {
        
        updateTable(l);
    
    }    
    
    private void updateTable(List l) {
        try {
            String columnNames[] = {};
            int columnsize[] = {};
            Object rowData[][] = new Object[l.size()][];
            DAOInterface obj;
            for (int i = 0; i < l.size(); i++){
               obj = (DAOInterface) l.get(i);                
               rowData[i] = obj.toArray();
               columnNames = obj.getColunas();
               columnsize = obj.getDefineRenderersColumn();
            }
        
            DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            this.setModel(tableModel);

            for (int i = 0; i < columnsize.length; i++){
               defineRenderers(i, columnsize[i]);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro atualizando a tabela: " + e.getMessage());
        }
    }

    public void atualiza(List l){
        updateTable(l);
    }

    private void defineRenderers(int column, int size) {
        
        TableColumnModel modeloDaColuna = this.getColumnModel();

        modeloDaColuna.getColumn(column).setMaxWidth(size);
    }
}
