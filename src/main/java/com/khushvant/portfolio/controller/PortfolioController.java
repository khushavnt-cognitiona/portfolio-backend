package com.khushvant.portfolio.controller;

import com.khushvant.portfolio.model.*;
import com.khushvant.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(portfolioService.getAllProjects());
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getSkills() {
        return ResponseEntity.ok(portfolioService.getAllSkills());
    }

    @GetMapping("/experience")
    public ResponseEntity<List<Experience>> getExperience() {
        return ResponseEntity.ok(portfolioService.getAllExperiences());
    }

    @GetMapping("/education")
    public ResponseEntity<List<Education>> getEducation() {
        return ResponseEntity.ok(portfolioService.getAllEducation());
    }

    @GetMapping("/certifications")
    public ResponseEntity<List<Certification>> getCertifications() {
        return ResponseEntity.ok(portfolioService.getAllCertifications());
    }
}
