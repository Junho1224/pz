package com.von.api.common.query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.von.api.article.ArticleDTO;

public interface QueryService<T> {

    List<T> findAll() throws SQLException;
    Optional<ArticleDTO> findById(Long id);
    String count();
    Optional<T> getOne(String id);
    Boolean existById(Long id);

    
}
