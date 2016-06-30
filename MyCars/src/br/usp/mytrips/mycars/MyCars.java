package br.usp.mytrips.mycars;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.*;
import javax.persistence.criteria.*;

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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		EntityManager manager= factory.createEntityManager();	
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> cq = cb.createQuery(Carro.class);
		Root<Carro> root = cq.from(Carro.class);
		ParameterExpression<String> arg = cb.parameter(String.class, "cidade");
		cq.select(root).where(cb.and(cb.equal(root.get("cidade"), arg)));
		TypedQuery<Carro> tq = manager.createQuery(cq);
		tq.setParameter(arg, cidade);
		List<Carro> lista = tq.getResultList();		
		manager.close();
		factory.close();
		return lista;
	}
	
}