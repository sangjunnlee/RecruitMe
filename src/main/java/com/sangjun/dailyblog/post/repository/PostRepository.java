package com.sangjun.dailyblog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangjun.dailyblog.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
 