/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Database;

import Persistencia.DAOInterface;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.type.ImageType;

/**
 *
 * @author MATHEUS-NOTE
 */

@Entity
@Table(name = "CAD_GASTOS")
public class CadGastos implements Serializable, DAOInterface {
        
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="ID_VIAGEM", referencedColumnName = "ID")
    private CadViagem viagem;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VALOR")
    private double valor;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "IMAGEM")
    private ImageType imagem;
    @Column(name = "IMAGEM_NOME")
    private String nomeImagem;

    public CadGastos() {}    

    public CadGastos(CadViagem viagem, String descricao, double valor, String tipo, ImageType imagem, String nomeImagem) {
        this.viagem = viagem;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.imagem = imagem;
        this.nomeImagem = nomeImagem;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CadViagem getViagem() {
        return viagem;
    }

    public void setViagem(CadViagem viagem) {
        this.viagem = viagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ImageType getImagem() {
        return imagem;
    }

    public void setImagem(ImageType imagem) {
        this.imagem = imagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    @Override
    public String[] getColunas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] getDefineRenderersColumn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getReferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
