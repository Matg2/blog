package com.blogproject.blog;

import org.springframework.data.repository.CrudRepository;


public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    
}
