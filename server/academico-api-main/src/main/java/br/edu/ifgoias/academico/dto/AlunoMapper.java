package br.edu.ifgoias.academico.dto;

import br.edu.ifgoias.academico.entities.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
	
	AlunoDTO toDTO(Aluno aluno);
	
	@Mapping(target = "cursos", ignore = true)
	Aluno toEntity(AlunoDTO alunoDTO);
}
