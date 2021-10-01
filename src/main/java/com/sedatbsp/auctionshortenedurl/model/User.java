package com.sedatbsp.auctionshortenedurl.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 1:48 AM
 * @project auction-shortened-url
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",unique = true,nullable = false,length = 100)
    private String username;

    @Column(name = "password",nullable = false,length = 100)
    private String password;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

}
