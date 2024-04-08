package com.von.api.article.service;

import com.von.api.article.model.Article;
import com.von.api.article.model.ArticleDTO;
import com.von.api.article.repository.ArticleRepository;
import com.von.api.common.AbstractService;
import com.von.api.common.component.MessengerVO;
import com.von.api.common.component.PageRequestVO;

import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;

    @Override
    public ArticleDTO save(ArticleDTO t) throws SQLException {
        return entityToDto(Optional.of(repository.save(dtoToEntity(t))));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<ArticleDTO> findAll() throws SQLException {
        //return repository.findAll(vo);
        return null;
    }

    @Override
    public Optional<ArticleDTO> findById(Long id) {
        return Optional.of(entityToDto(repository.findById(id)));
    }

    @Override
    public long count() {
        return repository.count();
    }


    @Override
    public Boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public ArticleDTO modify(ArticleDTO t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }
    
    
}
