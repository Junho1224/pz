package com.von.api.user.service;

import com.von.api.common.component.MessengerVO;
import com.von.api.user.model.User;
import com.von.api.user.model.UserDTO;
import com.von.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public MessengerVO save(UserDTO t) {
        entityToDto(repository.save(dtoToEntity(t)));
        return new MessengerVO();

    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return new MessengerVO();
    }

    @Override
    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
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
    public MessengerVO modify(UserDTO t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    
    @Override
    public String updatePassword(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");
    }

    @Override
    public List<UserDTO> findUsersByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByName'");
    }

    @Override
    public List<UserDTO> findUsersByJob(String job) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByJob'");
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public MessengerVO login(UserDTO param) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
