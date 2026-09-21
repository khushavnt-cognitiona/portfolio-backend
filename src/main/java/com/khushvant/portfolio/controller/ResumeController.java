package com.khushvant.portfolio.controller;

import com.khushvant.portfolio.model.Resume;
import com.khushvant.portfolio.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadResume() {
        Optional<Resume> resumeOpt = resumeService.getLatestResume();
        if (resumeOpt.isEmpty() || resumeOpt.get().getFileData() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Resume resume = resumeOpt.get();
        String downloadFileName = "Khushwant_Jadhao_CV.pdf";

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + downloadFileName + "\"")
                .body(resume.getFileData());
    }
}
