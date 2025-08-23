package org.training.chatti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDetailsDto {

    private int id;
    private int userId;
    private String title;
    private String content;
    private long commentsCount;

}
