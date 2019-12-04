package com.services.newsservice.controller.impl;

import com.services.newsservice.controller.NewsController;
import com.services.newsservice.model.NewsPost;
import com.services.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * News Api implementation.
 */
@RestController("news controller")
@RequestMapping("/news")
public class NewsControllerImpl implements NewsController {

    private NewsService newsService;

    /**
     * Constructor.
     *
     * @param newsService news service dependency
     */
    @Autowired
    public NewsControllerImpl(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<NewsPost>> getAllNews() {
        List<NewsPost> newsPosts = newsService.getAllNews();
        if (CollectionUtils.isEmpty(newsPosts)) {
            return ResponseEntity.notFound().build();
        }
        newsPosts.forEach(e -> e.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder
                .methodOn(NewsControllerImpl.class).getNewsById(e.getPostId())).withSelfRel()));
        return ResponseEntity.ok(newsPosts);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<NewsPost> getNewsById(@PathVariable int id) {
        NewsPost newsPost = newsService.getNewsById(id);
        if (newsPost != null) {
            newsPost.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder
                    .methodOn(NewsControllerImpl.class).getAllNews()).withRel("all-posts"));
            return ResponseEntity.ok(newsPost);
        }
        return ResponseEntity.notFound().build();
    }
}
