package com.example.neotour.dto.request;

import java.util.UUID;

public record CommentRequestDTO(UUID commentId,
                                String commentUsername,
                                String commentText,
                                String imageUrl) {
}
