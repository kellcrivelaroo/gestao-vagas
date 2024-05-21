package br.com.kellcrivelaro.gestao_vagas.modules.candidate.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.kellcrivelaro.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.kellcrivelaro.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidateService {
  @Autowired
  private CandidateRepository candidateRepository;

  public ProfileCandidateResponseDTO execute(UUID candidateId) {
    var candidate = this.candidateRepository.findById(candidateId)
        .orElseThrow(() -> {
          throw new UsernameNotFoundException("User not found");
        });

    var candidateDTO = ProfileCandidateResponseDTO.builder()
        .id(candidateId)
        .name(candidate.getName())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .description(candidate.getDescription())
        .build();

    return candidateDTO;
  }
}
