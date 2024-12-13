package acc.br.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddressDTO {
	 private String cep;

	    @JsonProperty
	    private String logradouro;

	    @JsonProperty
	    private String bairro;

	    @JsonProperty
	    private String localidade;

	    @JsonProperty
	    private String estado;

		
		}

	 
