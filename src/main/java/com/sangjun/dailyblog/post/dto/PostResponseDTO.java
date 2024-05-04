package com.sangjun.dailyblog.post.dto;

import com.sangjun.dailyblog.post.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostResponseDTO {
    private final String title;
    private final String content;

    public PostResponseDTO(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }

}
