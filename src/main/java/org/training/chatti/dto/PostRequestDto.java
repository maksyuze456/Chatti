package org.training.chatti.dto;

import java.time.LocalDate;

public record PostRequestDto(int userId, String title, String content, LocalDate createdAt) {
}
