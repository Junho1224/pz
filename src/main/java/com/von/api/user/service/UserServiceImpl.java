package com.von.api.user.service;

import com.von.api.common.component.MessengerVO;
import com.von.api.common.component.security.JwtProvider;
import com.von.api.user.model.User;
import com.von.api.user.model.UserDTO;
import com.von.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JwtProvider jwtProvider;
    private final UserRepository repository;

    @Override
    public MessengerVO save(UserDTO t) {
        entityToDto(repository.save(dtoToEntity(t)));
        return new MessengerVO();

        // User ent = repository.save(dtoToEntity(t));
        // System.out.println("========= UserServiceImpl save instanceof =========");
        // System.out.println((ent instanceof User) ? "SUCCESS": "FAILURE");
        // return MessengerVO.builder()
        // .message((ent instanceof User) ? "SUCCESS": "FAILURE")
        // .build();

    }

    @Override
    public MessengerVO modify(UserDTO userDto) { // 비밀번호 전화번호 직업
        repository.save(dtoToEntity(userDto));
        return MessengerVO.builder().message("True").build();

        // User ent = repository.save(dtoToEntity(userDto));
        // System.out.println(" ============ BoardServiceImpl modify instanceof
        // =========== ");
        // System.out.println((ent instanceof User) ? "SUCCESS" : "FAILURE");
        // return MessengerVO.builder()
        // .message((ent instanceof User) ? "SUCCESS" : "FAILURE")
        // .build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        String msg = repository.findById(id).isPresent() ? "SUCCESS" : "FAILURE";
        return MessengerVO.builder()
                .message(msg)
                .build();
        // return MessengerVO.builder()
        // .message(
        // Stream.of(id)
        // .filter(i -> repository.existsById(i))
        // .peek(i -> repository.deleteById(i))
        // .map(i -> "SUCCESS")
        // .findAny()
        // .orElseGet(() -> "FAILURE")
        // )
        // .build();
    }

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return repository.findById(id).map(this::entityToDto);
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

    // 단일책임원칙(SRP)에 따라 아이디 존재여부를 프론트에서 먼저 판단하고, 넘어옴 (시큐리티)
    @Transactional
    @Override
    public MessengerVO login(UserDTO dto) {
        log.info("로그인 서비스로 들어온 파라미터 : " + dto);
        var user = repository.findByUsername(dto.getUsername()).get();
        var accessToken = jwtProvider.createToken(entityToDto(user));
        var flag = user.getPassword().equals(dto.getPassword());
        // passwordEncoder.matches

        // 토큰을 각 섹션(Header, Payload, Signature)으로 분할
        jwtProvider.printPayload(accessToken);

        return MessengerVO.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? accessToken : "None")
                .build();
    }

    

    @Override
    public Boolean existsUsername(String username) {
        Integer count = repository.existsUsername(username);
        return count == 1;
    }

    @Transactional
    @Override
    public Boolean logout(String accessToken) {
        Long id = 0L;
        String deltetedToken ="";
        repository.modifyTokenById(id,deltetedToken);
        return repository.findById(id).get().getToken().equals("");
    }


}
