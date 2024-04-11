package com.von.api.board.model;


import java.util.List;

import com.von.api.article.model.Article;
import com.von.api.common.model.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

@ToString(exclude = {"id"})
@Entity(name="boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Board extends BaseEntity{

    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;
    private String boardType;

    @OneToMany(mappedBy ="board", fetch = FetchType.LAZY)
    private List<Article> articles;

}