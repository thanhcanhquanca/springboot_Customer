package com.example.customer_springboot.model.post.like;

import com.example.customer_springboot.model.post.Post;
import com.example.customer_springboot.model.user.CustomerProfile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private CustomerProfile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id" , nullable = false)
    private Post post;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private LikeType type = LikeType.LIKE;


}
