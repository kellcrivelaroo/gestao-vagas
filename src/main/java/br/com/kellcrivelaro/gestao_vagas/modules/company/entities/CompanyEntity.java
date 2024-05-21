package br.com.kellcrivelaro.gestao_vagas.modules.company.entities;

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

@Entity(name = "company")
@Data
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "Username não deve conter espaço")
  private String username;

  @Email(message = "E-mail inválido")
  private String email;

  @Length(min = 4, max = 80, message = "Senha deve conter entre 4 e 80 caracteres")
  private String password;

  private String website;

  private String name;

  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
