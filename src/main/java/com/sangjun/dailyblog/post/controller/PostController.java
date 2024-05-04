package com.sangjun.dailyblog.post.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sangjun.dailyblog.post.dto.PostRequestDTO;
import com.sangjun.dailyblog.post.dto.PostResponseDTO;
import com.sangjun.dailyblog.post.dto.UpdateArticleRequestDTO;
import com.sangjun.dailyblog.post.entity.Post;
import com.sangjun.dailyblog.post.service.PostService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {
    
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@RequestBody PostRequestDTO request) {
        Post savedPost = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostResponseDTO>> findAllPosts() {
        List<PostResponseDTO> posts = postService.findAllPosts()
            .stream()
            .map(PostResponseDTO::new)
            .toList();
        
        return ResponseEntity.ok()
                .body(posts);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostResponseDTO> findPostById(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        return ResponseEntity.ok()
            .body(new PostResponseDTO(post));
    }
    
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, 
        @RequestBody UpdateArticleRequestDTO request) {
        Post post = postService.updatePost(id, request);
        return ResponseEntity.ok().body(post);
    }
}

    
