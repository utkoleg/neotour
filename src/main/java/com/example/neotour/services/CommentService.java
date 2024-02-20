package com.example.neotour.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface CommentService {
    UUID addComment(UUID id, String commentUsername, String commentText, MultipartFile image);
}
