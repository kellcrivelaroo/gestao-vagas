package br.com.kellcrivelaro.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kellcrivelaro.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.kellcrivelaro.gestao_vagas.modules.company.entities.JobEntity;
import br.com.kellcrivelaro.gestao_vagas.modules.company.services.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {
  @Autowired
  private CreateJobService createJobService;

  @PostMapping()
  @PreAuthorize("hasRole('COMPANY')")
  public @Valid JobEntity create(@RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
    var companyId = request.getAttribute("company_id");
    System.out.println(companyId);
    var jobEntity = JobEntity.builder()
        .companyId(UUID.fromString(companyId.toString()))
        .description(createJobDTO.getDescription())
        .benefits(createJobDTO.getBenefits())
        .level(createJobDTO.getLevel())
        .build();

    return createJobService.execute(jobEntity);
  }
}