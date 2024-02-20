package com.example.neotour.dto.response;

import java.util.UUID;

public record CommentResponseDTO(UUID commentId,
                                 String commentUsername,
                                 String commentText,
                                 String imageUrl) {
}
