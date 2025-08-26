package org.training.chatti.dto;

import java.time.LocalDate;

public record PostResponseDto(int id, int userId, String title, String content, LocalDate createdAt) {
}
