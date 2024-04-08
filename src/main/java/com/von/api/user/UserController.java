package com.von.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.von.api.common.component.MessengerVO;
import com.von.api.user.model.User;
import com.von.api.user.model.UserDTO;
import com.von.api.user.repository.UserRepository;
import com.von.api.user.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.*;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository repo;
    private final UserServiceImpl service;



    @PostMapping(path = "")
    public ResponseEntity<MessengerVO> save(@RequestBody UserDTO user) throws SQLException {
        log.info("Save-회원가입 정보 : " + user);
        return ResponseEntity.ok(MessengerVO.builder()
                        .message(service.save(user).toString())
                        .build());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MessengerVO> deleteById(@PathVariable long id){
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVO());
    }
    @GetMapping(path = "")
    public ResponseEntity<List<UserDTO>> findAll(Pageable pageable) throws SQLException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<MessengerVO> findById(@PathVariable Long id){
        service.findById(0L);
        return ResponseEntity.ok(new MessengerVO());
    }
    @GetMapping(path = "/count")
    public ResponseEntity<MessengerVO> count(){
        service.count();
        return ResponseEntity.ok(new MessengerVO());
    }
    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<MessengerVO> existById(@PathVariable long id){
        service.existById(0L);
        return ResponseEntity.ok(new MessengerVO());
    }
}

//     @PostMapping(path = "/api/join")
//     public Map<String, ?> join(@RequestBody Map<String, ?> paramMap) {
//         User newUser = User.builder()
//                 .username((String) paramMap.get("username"))
//                 .password((String) paramMap.get("password"))
//                 .name((String) paramMap.get("name"))
//                 .phone((String) paramMap.get("phone"))
//                 .job((String) paramMap.get("job"))
//                 .build();
//         System.out.println("DB에 저장된 User 정보" + newUser);
//         repo.save(newUser);
//         System.out.println("성공?");
//         Map<String, MessengerVO> map = new HashMap<>();

//         return map;
//     }

//     @GetMapping("/api/users")
//     public Map<?,?> findAll() {
//         Map<String, Object> map = new HashMap<>();
//         List<User> list = new ArrayList<>();
//         list = service.findAll();
//         list.forEach(System.out::println);
//         System.out.println("리스트 사이즈 : "+list.size());
//         map.put("result",list);
//         return map;
//     }
    

//     @SuppressWarnings("unchecked")
//     @PostMapping("/api/login")
//     public Map<String, ?> userName(@RequestBody Map<String, ?> paramMap) {

//         Map<String, MessengerVO> resMap = new HashMap<>();

//         // String username = (String) paramMap.get("username");
//         // String password = (String) paramMap.get("password");
//         // System.out.println("username is " + username);
//         // System.out.println("password is " + password);


//         // User optUser = repo.findByUsername(username).orElse(null);
//         // if (optUser == null) {
//         //     resMap.put("message", MessengerVO.FAIL);
//         //     System.out.println("null");
//         //     return resMap;
//         // }else if (!optUser.getPassword().equals(password)){
//         //     resMap.put("message", MessengerVO.WRONG_PASSWORD);
//         // }else {
//         //     resMap.put("message", MessengerVO.SUCCESS);

//         // }
//         // Long id = optUser.getId();
//         // System.out.println("ID is" + id);
        
//         return resMap;
//     }



// }
