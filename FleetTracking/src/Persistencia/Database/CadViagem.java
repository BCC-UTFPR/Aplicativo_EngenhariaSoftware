package Persistencia.Database;

import Persistencia.DAOInterface;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "CAD_VIAGEM")
public class CadViagem implements Serializable, DAOInterface {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATA_CHEGADA")
    private Date dataChegada;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATA_SAIDA")
    private Date dataSaida;
    @Column(name = "KM_SAIDA")
    private double kmSaida;
    @Column(name = "KM_CHEGA")
    private double kmChegada;
    @Column(name = "RELATORIO_GASTOS")
    private String relatorioGastos;
    @Column(name = "RELATORIO_DANOS")
    private String relatorioDanos;
    @Column(name = "STATUS")
    private boolean finalizada;

    public CadViagem() {}

    public CadViagem(Date dataChegada, Date dataSaida, double kmSaida, double kmChegada, String relatorioGastos, String relatorioDanos, boolean finalizada) {
        this.dataChegada = dataChegada;
        this.dataSaida = dataSaida;
        this.kmSaida = kmSaida;
        this.kmChegada = kmChegada;
        this.relatorioGastos = relatorioGastos;
        this.relatorioDanos = relatorioDanos;
        this.finalizada = finalizada;
    }


    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getKmSaida() {
        return kmSaida;
    }

    public void setKmSaida(double kmSaida) {
        this.kmSaida = kmSaida;
    }

    public double getKmChegada() {
        return kmChegada;
    }

    public void setKmChegada(double kmChegada) {
        this.kmChegada = kmChegada;
    }

    public String getRelatorioGastos() {
        return relatorioGastos;
    }

    public void setRelatorioGastos(String relatorioGastos) {
        this.relatorioGastos = relatorioGastos;
    }

    public String getRelatorioDanos() {
        return relatorioDanos;
    }

    public void setRelatorioDanos(String relatorioDanos) {
        this.relatorioDanos = relatorioDanos;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    @Override
    public Long getId() {    
        return id;    
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String[] getColunas() {
        if (finalizada)
            return new String[]{"Id", "Funcionário", "Veículo", "Km Total", "Data Saída", "Data Chegada"};
        else
            return new String[]{"Id", "Funcionário", "Veículo", "Data Saída"};
    }

    @Override
    public Object[] toArray() {
        if (finalizada)
            return new Object[]{id, "", "", ""+(kmChegada-kmSaida), dataSaida, dataChegada};
        else
            return new Object[]{id, "", "", dataSaida};
    }

    @Override
    public int[] getDefineRenderersColumn() {
        if (finalizada)
            return new int[]{40, 140, 80, 80, 80, 80};
        else
            return new int[]{40, 160, 160, 140};
    }

    @Override
    public String getReferencia() {
        return "";
    }
    
    
}
