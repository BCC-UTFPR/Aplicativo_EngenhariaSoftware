package database;

import Persistencia.DAO;
import Persistencia.DAOInterface;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe Fronchetti
 */

@Entity
@Table(name = "CAD_Funcionario")
public class CadPessoas implements Serializable, DAOInterface {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome")
    private String Nome;
    @Column(name = "NumeroRegistro")
    private String NumeroRegistro;
    @Column(name = "RG")
    private String RG;
    @Column(name = "CNH")
    private String CNH;
    @Column(name = "ComentariosAdicionais")
    private String ComentariosAdicionais;

    public CadPessoas() {
    }

    /**
     *
     */
    public CadPessoas() {
        this.id = id;
        this.Nome = Nome;
        this.NumeroRegistro = NumeroRegistro;
        this.RG = RG;
        this.CNH = CNH;
        this.ComentariosAdicionais = ComentariosAdicionais;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public String getNumeroRegistro() {
		return NumeroRegistro;
	}
	
	public void setNumeroRegistro(String NumeroRegistro){
		this.NumeroRegistro = NumeroRegistro;
	}

    public String getRG() {
		return RG;
	}
	
	public void setRG(String RG){
		this.RG = RG;
	}
	
    public String getCNH() {
		return CNH;
	}
	
	public void setCNH(String CNH){
		this.CNH = CNH;
	}
	
	public String getComentariosAdicionais() {
		return ComentariosAdicionais;
	}
	
	public void setComentariosAdicionais(String ComentariosAdicionais){
		this.ComentariosAdicionais = ComentariosAdicionais;
	}

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
