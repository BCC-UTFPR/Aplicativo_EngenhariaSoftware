package Persistencia.Database;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CadVeiculo.class)
public abstract class CadVeiculo_ {

	public static volatile SingularAttribute<CadVeiculo, Long> id;
	public static volatile SingularAttribute<CadVeiculo, String> conservacao;
	public static volatile SingularAttribute<CadVeiculo, String> comentarios;
	public static volatile SingularAttribute<CadVeiculo, String> renavam;
	public static volatile SingularAttribute<CadVeiculo, String> placa;
	public static volatile SingularAttribute<CadVeiculo, Integer> ano;
	public static volatile SingularAttribute<CadVeiculo, String> marca;
	public static volatile SingularAttribute<CadVeiculo, String> categoriaCNH;
	public static volatile SingularAttribute<CadVeiculo, String> modelo;
	public static volatile SingularAttribute<CadVeiculo, Double> quilometragem;

}

