package com.von.api.article;


import java.util.*;
import com.von.api.common.command.CommandService;
import com.von.api.common.query.QueryService;


public interface ArticleService extends CommandService<ArticleDTO>, QueryService<ArticleDTO>{

    default Article dtoToEntity(ArticleDTO dto){

        Article article = Article.builder()
        .content(dto.getContent())
        .build();


        return article;
    }

    default Optional<ArticleDTO> entityToDto(Article ent){
        ArticleDTO dto = ArticleDTO.builder()
        
        .content(ent.getContent())
        .build();
        return Optional.of(dto);



    }



}
