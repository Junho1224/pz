package com.von.api.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.von.api.article.model.ArticleDTO;
import com.von.api.board.model.BoardDTO;
import com.von.api.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repository;

    @Override
    public BoardDTO save(BoardDTO t) throws SQLException {
        return entityToDto(Optional.of(repository.save(dtoToEntity(t))));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BoardDTO> findAll() throws SQLException {
        //return repository.findAll(vo);
        return null;
    }

    @Override
    public Optional<BoardDTO> findById(Long id) {
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
    public BoardDTO modify(BoardDTO t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }
    
}
