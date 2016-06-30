package br.usp.mytrips.mycars;
import javax.persistence.*;

@Entity
@Table(name="carros")
public class Carro {
	@Id
	@GeneratedValue
	int id;
	String modelo;
	String placa;
	String cidade;
}