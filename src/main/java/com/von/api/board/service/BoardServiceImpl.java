package com.von.api.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.von.api.article.model.ArticleDTO;
import com.von.api.board.model.BoardDTO;
import com.von.api.board.repository.BoardRepository;
import com.von.api.common.component.MessengerVO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repository;
    

    @Override
    public MessengerVO save(BoardDTO t){
        entityToDto(repository.save(dtoToEntity(t)));
        return new MessengerVO();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return new MessengerVO();
    }

    @Override
    public List<BoardDTO> findAll(){
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
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
    public MessengerVO modify(BoardDTO t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public Optional<BoardDTO> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
