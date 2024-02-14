package com.example.neotour.services;

import com.example.neotour.entities.Comment;
import com.example.neotour.entities.Tour;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface CommentService {
    Comment addComment(UUID id, String commentUsername, String commentText, MultipartFile image);
}
