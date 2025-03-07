package com.example.customer_springboot.model.user;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class CustomerUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Integer age;
    private String email;
    private String profileImage;
    private String bio;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private String status;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
//
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Post> posts;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Like> likes;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Share> shares;

}
