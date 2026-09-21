package com.khushvant.portfolio.controller;

import com.khushvant.portfolio.dto.ApiResponse;
import com.khushvant.portfolio.dto.ContactRequestDto;
import com.khushvant.portfolio.model.ContactMessage;
import com.khushvant.portfolio.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<ApiResponse<ContactMessage>> submitContactMessage(
            @Valid @RequestBody ContactRequestDto requestDto) {
        ContactMessage saved = contactService.saveContactMessage(requestDto);
        ApiResponse<ContactMessage> response = ApiResponse.<ContactMessage>builder()
                .success(true)
                .message("Thank you! Your message has been received successfully.")
                .data(saved)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
