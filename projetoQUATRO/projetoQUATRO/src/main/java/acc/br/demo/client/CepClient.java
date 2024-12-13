package acc.br.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import acc.br.demo.dto.AddressDTO;



@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep") // cria toda parte de logica de consumo de outra API
public interface CepClient {
	@GetMapping("/{cep}/json/") // é o endpoint a ser consumido, em {} é o cep que vai passar
	public AddressDTO getAddressByCep(@PathVariable("cep") String cep); // método que vai ser sobreescrito pelo feign
																		// por trás
//@PathVariable é variavel que vai na URL
}
