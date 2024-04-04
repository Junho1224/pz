package com.von.api.user;

import java.util.List;

import com.von.api.article.Article;
import com.von.api.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@ToString(exclude = { "id" })
public class User extends BaseEntity{

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;


    @OneToMany(mappedBy = "writer")
    private List<Article> articlesId;

    // @OneToMany(mappedBy = "user")
    // private List<Order> ordersId;



   

   
}