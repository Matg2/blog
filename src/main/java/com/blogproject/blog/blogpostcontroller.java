package com.blogproject.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;

@Controller
public class blogpostcontroller {

    @Autowired
    private BlogPostRepository blogPostRepository;
    private static List<BlogPost> posts = new ArrayList<>();
	
    
    @GetMapping(value="/")
    public String index(BlogPost blogPost, Model model) {
        model.addAttribute("posts", posts);
        return "blogpost/index";
        }

        private BlogPost blogPost;

        @GetMapping(value = "/blogpost/new")
public String newBlog (BlogPost blogPost, Model model) {
    return "blogpost/new";
}
//had to fix problem with post mapping for some reason if i added s to blog post in postmapping
//i would get i whitelabel error saying post now ssupported
//also changed blogposts to blogpost in actions area on form
    
    @PostMapping(value = "/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
	blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
    posts.add(blogPost);
	model.addAttribute("title", blogPost.getTitle());
	model.addAttribute("author", blogPost.getAuthor());
	model.addAttribute("blogEntry", blogPost.getBlogEntry());
	return "blogpost/result";
    }

}
