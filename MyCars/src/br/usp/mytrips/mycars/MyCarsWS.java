package br.usp.mytrips.mycars;

import java.util.Calendar;
import java.util.List;
import javax.jws.*;

@WebService(targetNamespace="http://localhost/MyCars/wsdl")
public interface MyCarsWS {
		@WebMethod
		public List<Carro> local(String cidade);
		
		@WebMethod
		public void reservar(int id, Calendar data);
}
