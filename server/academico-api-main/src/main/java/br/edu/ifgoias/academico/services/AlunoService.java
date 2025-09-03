package br.edu.ifgoias.academico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.ifgoias.academico.dto.AlunoDTO;
import br.edu.ifgoias.academico.dto.AlunoMapper;
import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.repositories.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRep;

    @Autowired
    private AlunoMapper alunoMapper;

    public Page<AlunoDTO> listaAlunos(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return alunoRep.findAll(pageable)
                .map(alunoMapper::toDTO);
    }

    public Page<AlunoDTO> listaAlunos(int page, int size, String search) {
        PageRequest pageable = PageRequest.of(page, size);
        if (search == null || search.trim().isEmpty()) {
            return alunoRep.findAll(pageable)
                    .map(alunoMapper::toDTO);
        } else {
            return alunoRep.findByNomeContainingIgnoreCase(search.trim(), pageable)
                    .map(alunoMapper::toDTO);
        }
    }

    public AlunoDTO alunoById(Integer id) {
        return alunoRep.findById(id)
                .map(alunoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
    }

    public AlunoDTO alunoInserir(AlunoDTO alunoDTO) {
        if (alunoDTO == null || alunoDTO.getNome() == null) {
            throw new IllegalArgumentException("Dados do aluno inválidos");
        }
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        alunoRep.save(aluno);
        return alunoMapper.toDTO(aluno);
    }

    public AlunoDTO alunoAlterar(Integer id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
        aluno.setNome(alunoDTO.getNome());
        aluno.setSexo(alunoDTO.getSexo());
        aluno.setDt_nasc(alunoDTO.getDt_nasc());
        alunoRep.save(aluno);
        return alunoMapper.toDTO(aluno);
    }

    public void alunoDeletar(Integer id) {
        Aluno aluno = alunoRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
        alunoRep.delete(aluno);
    }
}
