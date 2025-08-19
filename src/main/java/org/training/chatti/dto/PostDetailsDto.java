package org.training.chatti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostDetailsDto {

    private int id;
    private int userId;
    private String title;
    private String content;

}
