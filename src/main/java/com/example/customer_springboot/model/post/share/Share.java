package com.example.customer_springboot.model.post.share;

import com.example.customer_springboot.model.post.Post;
import com.example.customer_springboot.model.user.CustomerProfile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shares")
@Data
@NoArgsConstructor
public class Share {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private CustomerProfile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id" , nullable = false)
    private Post post;

    private LocalDateTime sharedAt;
    private String platform;

}
