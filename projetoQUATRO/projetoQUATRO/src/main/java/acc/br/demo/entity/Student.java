package acc.br.demo.entity;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //cria um builder onde encadeia a construção da classe
@NoArgsConstructor //cria um construtor sem argumento
@AllArgsConstructor// cria com todos argumentos
@Entity //Indica que esta classe é uma entidade gerenciada pelo JPA(banco)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate nascimento;
	private String course;

	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;

}
