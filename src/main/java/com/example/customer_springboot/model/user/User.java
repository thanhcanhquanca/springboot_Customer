package com.example.customer_springboot.model.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    private LocalDateTime lastActive;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL , optional = false)
    private CustomerProfile profile;

    @Transient
    public boolean isOnline() {
        if (lastActive == null) {
            return false;
        }else {
            Duration duration = Duration.between(lastActive, LocalDateTime.now());
            return duration.toMinutes() >= 1;
        }
    }

}
