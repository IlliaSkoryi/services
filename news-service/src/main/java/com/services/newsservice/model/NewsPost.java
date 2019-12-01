package com.services.newsservice.model;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "news", schema = "srv")
public class NewsPost extends ResourceSupport {

    @Id
    @Column(name = "id")
    private int postId;

    @Column(name = "title")
    private String title;
    @Column(name = "post")
    private String post;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsPost newsPost = (NewsPost) o;
        return postId == newsPost.postId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }
}
