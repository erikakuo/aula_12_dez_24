package acc.br.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentDto {

	private String name;
	private String cep;
	private String course;
	private LocalDate nascimento;
	
	
	
	
	
}
