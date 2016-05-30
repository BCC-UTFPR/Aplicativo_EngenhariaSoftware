package Persistencia.Database;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CadViagem.class)
public abstract class CadViagem_ {

	public static volatile SingularAttribute<CadViagem, Long> id;
	public static volatile SingularAttribute<CadViagem, Boolean> finalizada;
	public static volatile SingularAttribute<CadViagem, String> relatorioDanos;
	public static volatile SingularAttribute<CadViagem, Date> dataChegada;
	public static volatile SingularAttribute<CadViagem, CadFuncionario> motorista;
	public static volatile SingularAttribute<CadViagem, Double> kmSaida;
	public static volatile SingularAttribute<CadViagem, Double> kmChegada;
	public static volatile SingularAttribute<CadViagem, Date> dataSaida;
	public static volatile SingularAttribute<CadViagem, String> relatorioGastos;
	public static volatile SingularAttribute<CadViagem, CadVeiculo> veiculo;

}

