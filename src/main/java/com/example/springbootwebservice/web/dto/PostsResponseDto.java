package com.example.springbootwebservice.web.dto;

import com.example.springbootwebservice.domain.posts.Posts;

public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getContent();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
