package com.khushvant.portfolio.service;

import com.khushvant.portfolio.model.Resume;
import com.khushvant.portfolio.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Transactional
    public Resume saveResume(String fileName, String contentType, byte[] fileData) {
        Resume resume = Resume.builder()
                .fileName(fileName)
                .contentType(contentType)
                .fileData(fileData)
                .uploadedAt(LocalDateTime.now())
                .build();
        return resumeRepository.save(resume);
    }

    @Transactional(readOnly = true)
    public Optional<Resume> getLatestResume() {
        return resumeRepository.findTopByOrderByIdDesc();
    }

    @Transactional(readOnly = true)
    public boolean hasResume() {
        return resumeRepository.count() > 0;
    }
}
