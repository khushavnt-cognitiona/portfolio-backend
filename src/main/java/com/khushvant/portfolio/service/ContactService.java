package com.khushvant.portfolio.service;

import com.khushvant.portfolio.dto.ContactRequestDto;
import com.khushvant.portfolio.model.ContactMessage;
import com.khushvant.portfolio.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessage saveContactMessage(ContactRequestDto requestDto) {
        ContactMessage message = ContactMessage.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .subject(requestDto.getSubject())
                .message(requestDto.getMessage())
                .build();
        return contactMessageRepository.save(message);
    }
}
