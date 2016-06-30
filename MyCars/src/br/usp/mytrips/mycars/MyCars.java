package br.usp.mytrips.mycars;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.*;

@Stateless
@WebService(portName="MyCarsPort", serviceName="MyCarsService", targetNamespace="http://localhost/MyCars/wsdl", endpointInterface="MyCarsWS")
public class MyCars implements MyCarsWS{
	
	@WebMethod
	Carro getCarro(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		EntityManager manager= factory.createEntityManager();
		manager.getTransaction().begin();
		Carro carro = new Carro();
		manager.persist(carro);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return carro;
	}

	@WebMethod
	public List<Carro> local(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
}