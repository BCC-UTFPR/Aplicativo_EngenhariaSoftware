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
@Table(name = "CAD_Veiculo")
public class CadPessoas implements Serializable, DAOInterface {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DataChegada")
    private String DataChegada;
    @Column(name = "DataSaida")
    private String DataSaida;
    @Column(name = "QuilometragemSaida")
    private String QuilometragemSaida;
    @Column(name = "QuilometragemChegada")
    private String QuilometragemChegada;
    @Column(name = "RelatorioGastos")
    private String RelatorioGastos;
    @Column(name = "RelatorioDanos")
    private String RelatorioDanos;

    public CadPessoas() {
    }

    public CadPessoas() {
        this.id = id;
        this.DataSaida = DataSaida;
        this.DataChegada = DataChegada;
        this.QuilometragemSaida = QuilometragemSaida;
        this.QuilometragemChegada = QuilometragemChegada;
		this.RelatorioDanos = RelatorioDanos;
		this.RelatorioGastos = RelatorioGastos;
    }

    public String getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(String DataSaida) {
        this.DataSaida = DataSaida;
    }
    
    public String getDataChegada() {
		return DataChegada;
	}
	
	public void setDataChegada(String DataChegada){
		this.DataChegada = DataChegada;
	}

    public String getQuilometragemSaida() {
		return QuilometragemSaida;
	}
	
	public void setQuilometragemSaida(String QuilometragemSaida){
		this.QuilometragemSaida = QuilometragemSaida;
	}
	
    public String getQuilometragemChegada() {
		return QuilometragemChegada;
	}
	
	public void setQuilometragemChegada(String QuilometragemChegada){
		this.QuilometragemChegada = QuilometragemChegada;
	}
	
	public String getRelatorioDanos() {
		return RelatorioDanos;
	}
	
	public void setRelatorioDanos(String RelatorioDanos){
		this.RelatorioDanos = RelatorioDanos;
	}
	
	public String getRelatorioGastos() {
		return RelatorioGastos;
	}
	
	public void setRelatorioGastos(String RelatorioGastos){
		this.RelatorioGastos = RelatorioGastos;
	}
}
