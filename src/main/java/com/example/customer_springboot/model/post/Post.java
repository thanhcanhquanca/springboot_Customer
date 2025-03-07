package com.example.customer_springboot.model.post;

import com.example.customer_springboot.model.post.comment.Comment;
import com.example.customer_springboot.model.post.like.Like;
import com.example.customer_springboot.model.post.share.Share;
import com.example.customer_springboot.model.user.CustomerProfile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String image;
    private LocalDateTime createdAt;
    private Long likeCount = 0L;
    private Long viewCount = 0L;
    private Long commentCount = 0L;
    private Long shareCount = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id" , nullable = false)
    private CustomerProfile author;

    @Enumerated(EnumType.STRING)
    private PostPrivacyStatus privacyStatus = PostPrivacyStatus.PUBLIC;

    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Share> shares = new ArrayList<>();


}
