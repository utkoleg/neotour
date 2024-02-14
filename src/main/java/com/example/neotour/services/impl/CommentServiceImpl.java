package com.example.neotour.services.impl;

import com.example.neotour.entities.Comment;
import com.example.neotour.entities.Tour;
import com.example.neotour.repositories.CommentRepository;
import com.example.neotour.repositories.TourRepository;
import com.example.neotour.services.CommentService;
import com.example.neotour.services.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final TourRepository tourRepository;
    private final CommentRepository commentRepository;
    private final FileUploadService fileUploadService;
    @Override
    public Comment addComment(UUID id, String commentUsername, String commentText, MultipartFile image) {
        Tour tour = tourRepository.findById(id).orElseThrow();
        Comment comment = new Comment();
        comment.setCommentUsername(commentUsername);
        comment.setCommentText(commentText);
        try {
            comment.setImageUrl(fileUploadService.uploadFile(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tour.getComments().add(comment);
        return commentRepository.save(comment);
    }
}
