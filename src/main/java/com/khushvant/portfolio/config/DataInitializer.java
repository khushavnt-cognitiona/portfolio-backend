package com.khushvant.portfolio.config;

import com.khushvant.portfolio.model.*;
import com.khushvant.portfolio.repository.*;
import com.khushvant.portfolio.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;
    private final CertificationRepository certificationRepository;
    private final ResumeRepository resumeRepository;
    private final ResumeService resumeService;

    @Override
    public void run(String... args) throws Exception {
        if (projectRepository.count() == 0) {
            projectRepository.saveAll(List.of(
                    Project.builder()
                            .title("Job Application Portal")
                            .description("A full-stack web application for job posting, searching, and tracking applications with JWT authentication and role-based access.")
                            .image("/images/project-job-portal.png")
                            .technologies(List.of("Java", "Spring Boot", "React", "MySQL"))
                            .demoUrl("#")
                            .githubUrl("https://github.com/khushavnt-cognitiona")
                            .accentColor("from-indigo-500 to-purple-600")
                            .build(),
                    Project.builder()
                            .title("Grocery Management System")
                            .description("E-commerce platform with product management, cart, orders, payment integration and multiple user roles.")
                            .image("/images/project-grocery.png")
                            .technologies(List.of("Java", "Spring Boot", "React", "MySQL"))
                            .demoUrl("#")
                            .githubUrl("https://github.com/khushavnt-cognitiona")
                            .accentColor("from-emerald-500 to-teal-600")
                            .build(),
                    Project.builder()
                            .title("Hotel Management System")
                            .description("Hotel booking and room management system with secure authentication and CRUD operations.")
                            .image("/images/project-hotel.png")
                            .technologies(List.of("Java", "Spring Boot", "Thymeleaf", "MySQL"))
                            .demoUrl("#")
                            .githubUrl("https://github.com/khushavnt-cognitiona")
                            .accentColor("from-amber-500 to-orange-600")
                            .build()
            ));
        }

        if (skillRepository.count() == 0) {
            skillRepository.saveAll(List.of(
                    Skill.builder().name("Java").category("Backend").icon("Coffee").color("#E76F51").badgeBg("bg-orange-50 text-orange-600").build(),
                    Skill.builder().name("Spring Boot").category("Backend").icon("Leaf").color("#6DB33F").badgeBg("bg-emerald-50 text-emerald-600").build(),
                    Skill.builder().name("React").category("Frontend").icon("Atom").color("#61DAFB").badgeBg("bg-cyan-50 text-cyan-600").build(),
                    Skill.builder().name("MySQL").category("Database").icon("Database").color("#00758F").badgeBg("bg-sky-50 text-sky-700").build(),
                    Skill.builder().name("HTML5").category("Frontend").icon("Code").color("#E34F26").badgeBg("bg-orange-50 text-orange-600").build(),
                    Skill.builder().name("CSS3").category("Frontend").icon("Palette").color("#1572B6").badgeBg("bg-blue-50 text-blue-600").build(),
                    Skill.builder().name("Tailwind CSS").category("Frontend").icon("Wind").color("#06B6D4").badgeBg("bg-cyan-50 text-cyan-600").build(),
                    Skill.builder().name("Hibernate").category("Backend").icon("Layers").color("#59666C").badgeBg("bg-slate-50 text-slate-700").build(),
                    Skill.builder().name("Git").category("Tools & Cloud").icon("GitBranch").color("#F05032").badgeBg("bg-red-50 text-red-600").build(),
                    Skill.builder().name("Docker").category("Tools & Cloud").icon("Box").color("#2496ED").badgeBg("bg-blue-50 text-blue-600").build(),
                    Skill.builder().name("AWS").category("Tools & Cloud").icon("Cloud").color("#FF9900").badgeBg("bg-amber-50 text-amber-600").build(),
                    Skill.builder().name("VS Code").category("Tools & Cloud").icon("Laptop").color("#007ACC").badgeBg("bg-blue-50 text-blue-600").build(),
                    Skill.builder().name("Postman").category("Tools & Cloud").icon("Send").color("#FF6C37").badgeBg("bg-orange-50 text-orange-600").build()
            ));
        }

        if (experienceRepository.count() == 0) {
            experienceRepository.saveAll(List.of(
                    Experience.builder()
                            .role("Java Backend Developer")
                            .company("Cognition Technology")
                            .duration("Dec 2022 – Jul 2023")
                            .color("orange")
                            .badgeBg("bg-orange-100 text-orange-800")
                            .responsibilities(List.of(
                                    "Developed backend REST APIs for a Grocery Management E-commerce application using Spring Boot.",
                                    "Worked with JdbcTemplate, RowMapper and MySQL for database operations.",
                                    "Implemented backend business logic and database operations.",
                                    "Worked on API development and integration."
                            ))
                            .build(),
                    Experience.builder()
                            .role("Full Stack Java Developer")
                            .company("ARC Technology & Institute")
                            .duration("During MCA")
                            .color("cyan")
                            .badgeBg("bg-cyan-100 text-cyan-800")
                            .responsibilities(List.of(
                                    "Developed full-stack applications using Java, Spring Boot, React.js and MySQL.",
                                    "Built REST APIs and integrated them with React frontend.",
                                    "Worked on CRUD operations, authentication and database integration.",
                                    "Gained hands-on experience in end-to-end application development."
                            ))
                            .build()
            ));
        }

        if (educationRepository.count() == 0) {
            educationRepository.saveAll(List.of(
                    Education.builder().title("MCA (AI & ML)").institution("Chandigarh University").status("Completed").icon("GraduationCap").build(),
                    Education.builder().title("B.Voc in Software Development").institution("Sant Gadge Baba Amravati University").year("2022").icon("BookOpen").build(),
                    Education.builder().title("Strategic HR Management (Certificate)").institution("Amity University").year("May 2024").icon("Briefcase").build()
            ));
        }

        if (certificationRepository.count() == 0) {
            certificationRepository.saveAll(List.of(
                    Certification.builder().name("Team Management").issuer("Harvard ManageMentor").build(),
                    Certification.builder().name("Decision Making").issuer("Harvard ManageMentor").build(),
                    Certification.builder().name("Presentation Skills").issuer("Harvard ManageMentor").build(),
                    Certification.builder().name("Business Plan Development").issuer("Harvard ManageMentor").build(),
                    Certification.builder().name("Strategy Planning & Execution").issuer("Harvard ManageMentor").build()
            ));
        }

        if (resumeRepository.count() == 0) {
            try {
                ClassPathResource resource = new ClassPathResource("pdf/Khushwant_Jadhao.pdf");
                if (resource.exists()) {
                    byte[] pdfBytes = resource.getInputStream().readAllBytes();
                    resumeService.saveResume("Khushwant_Jadhao.pdf", "application/pdf", pdfBytes);
                }
            } catch (Exception e) {
                System.err.println("Could not initialize resume PDF: " + e.getMessage());
            }
        }
    }
}
