package br.com.kellcrivelaro.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "Username não deve conter espaços")
  private String username;

  @Length(min = 4, max = 80, message = "Senha deve conter entre 4 e 80 caracteres")
  private String password;

  @Email(message = "E-mail inválido")
  private String email;

  private String curriculum;

  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
