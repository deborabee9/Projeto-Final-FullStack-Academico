package br.edu.ifgoias.academico.repositories;

import br.edu.ifgoias.academico.entities.Curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

    @Query("SELECT c FROM Curso c WHERE LOWER(c.nomeCurso) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Curso> findByNomeCursoContainingIgnoreCase(@Param("search") String search, Pageable pageable);

}

