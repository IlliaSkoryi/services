package com.services.newsservice.controller;

import com.services.newsservice.model.NewsPost;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * News API interface.
 */
public interface NewsController {

    /**
     * Retrieves list of all existing {@link NewsPost}.
     *
     * @return list of {@link NewsPost}
     */
    ResponseEntity<List<NewsPost>> getAllNews();

    /**
     * Retrieves {@link NewsPost} by id.
     *
     * @param id {@link NewsPost} id
     * @return {@link ResponseEntity} of {@link NewsPost}
     */
    ResponseEntity<NewsPost> getNewsById(@PathVariable int id);
}
