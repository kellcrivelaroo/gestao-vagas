package br.com.kellcrivelaro.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
  // DTO = Data Transfer to Object
  private String message;
  private String field;
}
