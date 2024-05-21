package br.com.kellcrivelaro.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kellcrivelaro.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.kellcrivelaro.gestao_vagas.modules.candidate.services.AuthCandidateService;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {
  @Autowired
  private AuthCandidateService authCandidateService;

  @PostMapping("/auth")
  public ResponseEntity<Object> create(@RequestBody AuthCandidateRequestDTO authCandidateDTO) {
    try {
      var result = this.authCandidateService.execute(authCandidateDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }
}
