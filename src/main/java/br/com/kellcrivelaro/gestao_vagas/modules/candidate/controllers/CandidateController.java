package br.com.kellcrivelaro.gestao_vagas.modules.candidate.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kellcrivelaro.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.kellcrivelaro.gestao_vagas.modules.candidate.services.CreateCandidateService;
import br.com.kellcrivelaro.gestao_vagas.modules.candidate.services.ProfileCandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
  @Autowired
  private CreateCandidateService createCandidateService;

  @Autowired
  private ProfileCandidateService profileCandidateService;

  @PostMapping()
  public @Valid ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    try {
      var result = this.createCandidateService.execute(candidateEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping()
  @PreAuthorize("hasRole('CANDIDATE')")
  public ResponseEntity<Object> get(HttpServletRequest request) {
    var candidateId = request.getAttribute("candidate_id");

    try {
      var profile = this.profileCandidateService.execute(UUID.fromString(candidateId.toString()));
      return ResponseEntity.ok().body(profile);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
