package org.training.chatti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class UserWithPostsDto {

    private int id;
    private String username;
    private List<PostDetailsDto> posts;
}
