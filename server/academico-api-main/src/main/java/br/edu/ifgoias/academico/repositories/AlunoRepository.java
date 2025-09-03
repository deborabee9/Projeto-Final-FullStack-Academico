package br.edu.ifgoias.academico.repositories;

import br.edu.ifgoias.academico.entities.Aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

    @Query("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Aluno> findByNomeContainingIgnoreCase(@Param("search") String search, Pageable pageable);

}
