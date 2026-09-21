package com.khushvant.portfolio.service;

import com.khushvant.portfolio.model.*;
import com.khushvant.portfolio.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;
    private final CertificationRepository certificationRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }
}
