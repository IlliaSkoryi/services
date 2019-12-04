package com.services.newsservice.service;

import com.services.newsservice.model.NewsPost;

import java.util.List;

/**
 * News service API.
 */
public interface NewsService {

    /**
     * Provides ability to retrieve list of all {@link NewsPost} from persistence layer.
     *
     * @return list of {@link NewsPost} entities
     */
    List<NewsPost> getAllNews();

    /**
     * Provides ability to retrieve {@link NewsPost} from persistence layer by id.
     *
     * @param id {@link NewsPost} id
     * @return {@link NewsPost} entity
     */
    NewsPost getNewsById(int id);
}
