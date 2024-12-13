package acc.br.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.br.demo.dto.AddressDTO;
import acc.br.demo.dto.StudentDto;
import acc.br.demo.entity.Student;
import acc.br.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {


	private AddressService addressService;
	
	
	private StudentRepository repository;
	
	public Student create(StudentDto studentDto) {
		
		  AddressDTO addressDTO = addressService.get(studentDto.getCep());; //consultando o endereço
		
		  
		Student student = Student.builder()
		.course(studentDto.getCourse())
		.name(studentDto.getName())
		.nascimento(studentDto.getNascimento())
		.bairro(addressDTO.getBairro())
		.cidade(addressDTO.getLocalidade())
		.estado(addressDTO.getEstado())
		.logradouro(addressDTO.getLogradouro())
		.cep(addressDTO.getCep())
		.build();
		
		return repository.save(student);
		
		
		
		
	}

}
