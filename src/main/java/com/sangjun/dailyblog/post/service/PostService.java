package com.sangjun.dailyblog.post.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sangjun.dailyblog.post.dto.PostRequestDTO;
import com.sangjun.dailyblog.post.dto.UpdateArticleRequestDTO;
import com.sangjun.dailyblog.post.entity.Post;
import com.sangjun.dailyblog.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post save(PostRequestDTO request) {
        return postRepository.save(request.toEntity());
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Post updatePost(Long id, UpdateArticleRequestDTO request) {
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        post.update(request.getTitle(), request.getContent());
        
        return post;
    }
}
