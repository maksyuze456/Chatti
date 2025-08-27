package org.training.chatti.dto;

import java.time.LocalDate;

public record CommentRequestDto(int userId, int postId, String content, LocalDate createdAt) {
}
