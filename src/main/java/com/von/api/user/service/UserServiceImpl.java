package com.von.api.user.service;

import com.von.api.article.model.ArticleDTO;
import com.von.api.common.AbstractService;
import com.von.api.common.component.MessengerVO;
import com.von.api.user.model.User;
import com.von.api.user.model.UserDTO;
import com.von.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@SuppressWarnings("rawtypes")
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService implements UserService{

    private final UserRepository repository;

    @Override
    public UserDTO save(UserDTO t) throws SQLException {
        return entityToDto(repository.save(dtoToEntity(t)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDTO> findAll() throws SQLException {
        return repository.findAll().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
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
    public UserDTO modify(UserDTO t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

}
