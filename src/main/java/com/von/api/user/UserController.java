package com.von.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.von.api.common.component.MessengerVO;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;
    private final UserServiceImpl service;


    @PostMapping(path = "/api/join")
    public Map<String, ?> join(@RequestBody Map<String, ?> paramMap) {
        User newUser = User.builder()
                .username((String) paramMap.get("username"))
                .password((String) paramMap.get("password"))
                .name((String) paramMap.get("name"))
                .phone((String) paramMap.get("phone"))
                .job((String) paramMap.get("job"))
                .build();
        System.out.println("DB에 저장된 User 정보" + newUser);
        repo.save(newUser);
        System.out.println("성공?");
        Map<String, MessengerVO> map = new HashMap<>();

        return map;
    }

    @GetMapping("/api/users")
    public Map<?,?> findAll() {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        list = service.findAll();
        list.forEach(System.out::println);
        System.out.println("리스트 사이즈 : "+list.size());
        map.put("result",list);
        return map;
    }
    

    @SuppressWarnings("unchecked")
    @PostMapping("/api/login")
    public Map<String, ?> userName(@RequestBody Map<String, ?> paramMap) {

        Map<String, MessengerVO> resMap = new HashMap<>();

        // String username = (String) paramMap.get("username");
        // String password = (String) paramMap.get("password");
        // System.out.println("username is " + username);
        // System.out.println("password is " + password);


        // User optUser = repo.findByUsername(username).orElse(null);
        // if (optUser == null) {
        //     resMap.put("message", MessengerVO.FAIL);
        //     System.out.println("null");
        //     return resMap;
        // }else if (!optUser.getPassword().equals(password)){
        //     resMap.put("message", MessengerVO.WRONG_PASSWORD);
        // }else {
        //     resMap.put("message", MessengerVO.SUCCESS);

        // }
        // Long id = optUser.getId();
        // System.out.println("ID is" + id);
        
        return resMap;
    }




    public Map<String, ?> save(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> login(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> changePassword(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> delete(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> findUsersByName(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> findUsersByJob(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> count() {
        return null;
    }

    public Map<String, ?> findUsers() throws SQLException {
        return null;
    }

    public void createTable() throws SQLException {
    }

    public void deleteTable() throws SQLException {
    }

    public Map<String, ?> getOne(@RequestBody Map<String, ?> map) {
        return null;
    }

    public Map<String, ?> findUser(@RequestBody Map<String, ?> map) {
        return null;
    }
}
