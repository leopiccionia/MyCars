package br.usp.mytrips.mycars;
import java.util.Calendar;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="carros")
@XmlAccessorType
@XmlType
public class Carro {
	@Id
	@GeneratedValue
	@XmlElement
	int id;
	@XmlElement
	String modelo;
	@XmlElement
	String placa;
	String cidade;
	@Temporal(TemporalType.DATE)
	Calendar disponivel_em;
}