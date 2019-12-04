package com.services.newsservice.service.impl;

import com.services.newsservice.model.NewsPost;
import com.services.newsservice.repository.NewsRepository;
import com.services.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User service API implementation.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    /**
     * Constructor.
     *
     * @param newsRepository news Repository dependency
     */
    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsPost> getAllNews() {
        List<NewsPost> newsPosts = newsRepository.findAll();
        return newsPosts;
    }

    @Override
    public NewsPost getNewsById(int id) {
        Optional<NewsPost> newsPost = newsRepository.findById(id);
        return newsPost.orElse(null);
    }
}
