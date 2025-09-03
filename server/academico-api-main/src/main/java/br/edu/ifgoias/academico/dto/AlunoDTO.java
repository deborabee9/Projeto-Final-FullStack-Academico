package br.edu.ifgoias.academico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

	private Integer idaluno;

	@NotNull(message = "O nome do aluno é obrigatório")
	@NotBlank(message = "O nome do aluno é obrigatório")
	@Size(max = 100, message = "O nome do aluno deve ter no máximo 100 caracteres")
	private String nome;

	@NotNull(message = "O sexo do aluno é obrigatório")
	@NotBlank(message = "O sexo do aluno é obrigatório")
	@Size(max = 1, message = "O sexo deve ter apenas 1 caractere (M/F)")
	private String sexo;

	@NotNull(message = "A data de nascimento é obrigatória")
	private LocalDate dt_nasc;

	public Integer getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(Integer idaluno) {
		this.idaluno = idaluno;
	}

	public @NotNull(message = "O nome do aluno é obrigatório") @NotBlank(message = "O nome do aluno é obrigatório") @Size(max = 100, message = "O nome do aluno deve ter no máximo 100 caracteres") String getNome() {
		return nome;
	}

	public void setNome(@NotNull(message = "O nome do aluno é obrigatório") @NotBlank(message = "O nome do aluno é obrigatório") @Size(max = 100, message = "O nome do aluno deve ter no máximo 100 caracteres") String nome) {
		this.nome = nome;
	}

	public @NotNull(message = "O sexo do aluno é obrigatório") @NotBlank(message = "O sexo do aluno é obrigatório") @Size(max = 1, message = "O sexo deve ter apenas 1 caractere (M/F)") String getSexo() {
		return sexo;
	}

	public void setSexo(@NotNull(message = "O sexo do aluno é obrigatório") @NotBlank(message = "O sexo do aluno é obrigatório") @Size(max = 1, message = "O sexo deve ter apenas 1 caractere (M/F)") String sexo) {
		this.sexo = sexo;
	}

	public @NotNull(message = "A data de nascimento é obrigatória") LocalDate getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(@NotNull(message = "A data de nascimento é obrigatória") LocalDate dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
}
