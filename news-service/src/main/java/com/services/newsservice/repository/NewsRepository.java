package com.services.newsservice.repository;

import com.services.newsservice.model.NewsPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<NewsPost, Integer> {

    @Override
    List<NewsPost> findAll();
}
