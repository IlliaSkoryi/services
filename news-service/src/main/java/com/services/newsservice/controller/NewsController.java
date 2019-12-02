package com.services.newsservice.controller;

import com.services.newsservice.model.NewsPost;
import com.services.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController("news controller")
@RequestMapping("/news")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsPost> getNewsById(@PathVariable int id) {
        NewsPost newsPost = newsService.getNewsById(id);
        if (newsPost != null) {
            newsPost.add(linkTo(methodOn(NewsController.class).getAllNews()).withRel("all-posts"));
            return ResponseEntity.ok(newsPost);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<NewsPost>> getAllNews() {
        List<NewsPost> newsPosts = newsService.getAllNews();
        if (CollectionUtils.isEmpty(newsPosts)) {
            return ResponseEntity.notFound().build();
        }
        newsPosts.forEach(e -> e.add(linkTo(methodOn(NewsController.class).getNewsById(e.getPostId())).withSelfRel()));
        return ResponseEntity.ok(newsPosts);
    }
}
