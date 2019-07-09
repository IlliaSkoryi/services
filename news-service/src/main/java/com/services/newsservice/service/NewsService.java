package com.services.newsservice.service;

import com.services.newsservice.model.NewsPost;

import java.util.List;

public interface NewsService {

    List<NewsPost> getAllNews();

    NewsPost getNewsById(int id);
}
