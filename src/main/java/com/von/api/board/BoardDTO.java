package com.von.api.board;

import java.util.List;

import org.springframework.stereotype.Component;

import com.von.api.article.Article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private List<Article> articles;

    
}
