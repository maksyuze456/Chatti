package org.training.chatti.dto;

import java.time.LocalDate;

public record CommentDto(int id, int userId, int postId, String content, LocalDate createdAt) {
}
