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

@RestController("news controller")
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/{id}")
    public ResponseEntity getNewsById(@PathVariable int id) {
        NewsPost newsPost = newsService.getNewsById(id);
        if (newsPost != null) {
            return ResponseEntity.ok(newsPost);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity getAllNews() {
        List<NewsPost> newsPosts = newsService.getAllNews();
        if (CollectionUtils.isEmpty(newsPosts)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newsPosts);
    }
}
