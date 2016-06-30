package br.usp.mytrips.mycars;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="carros")
@XmlAccessorType
@XmlType
public class Carro {
	@Id
	@GeneratedValue
	int id;
	@XmlElement
	String modelo;
	@XmlElement
	String placa;
	@XmlElement
	String cidade;
}