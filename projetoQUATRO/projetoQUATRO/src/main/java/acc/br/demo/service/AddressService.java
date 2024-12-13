package acc.br.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.br.demo.client.CepClient;
import acc.br.demo.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class AddressService {

	
	private CepClient cepClient;

	public AddressDTO get(String cep) { //service na consulta de endereço
		return cepClient.getAddressByCep(cep);
	}

}
