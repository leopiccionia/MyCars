package br.usp.mytrips.mycars;

import java.util.List;
import javax.jws.*;

@WebService(targetNamespace="http://localhost/MyCars/wsdl")
public interface MyCarsWS {
		@WebMethod
		public List<Carro> local(String cidade);
}
