package com.von.api.article.service;


import java.util.*;

import com.von.api.article.model.Article;
import com.von.api.article.model.ArticleDTO;
import com.von.api.common.service.CommandService;
import com.von.api.common.service.QueryService;


public interface ArticleService extends CommandService<ArticleDTO>, QueryService<ArticleDTO>{

    default Article dtoToEntity(ArticleDTO dto){    //dto 를 entity로 바꾸는 것
        return Article.builder().build();
    }

    default ArticleDTO entityToDto(Optional<Article> ent){ //entity 를 dto로 바꾸는 것
        return ArticleDTO.builder().build();
    }
}


