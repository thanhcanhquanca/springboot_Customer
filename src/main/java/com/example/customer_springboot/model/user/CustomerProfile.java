package com.example.customer_springboot.model.user;

import com.example.customer_springboot.model.post.Post;
import com.example.customer_springboot.model.post.comment.Comment;
import com.example.customer_springboot.model.post.like.Like;
import com.example.customer_springboot.model.post.share.Share;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_profile")
@Data
@NoArgsConstructor
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String age;
    private String email;
    private String profileImage;
    private String coverImage;
    private String bio;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Share> shares = new ArrayList<>();





}
