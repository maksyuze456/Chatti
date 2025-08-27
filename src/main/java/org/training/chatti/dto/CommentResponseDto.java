package org.training.chatti.dto;

import java.time.LocalDate;

public record CommentResponseDto(int id, int userId, int postId, String content, LocalDate createdAt) {
}
