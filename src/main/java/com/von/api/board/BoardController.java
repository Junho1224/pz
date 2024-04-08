package com.von.api.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.von.api.board.service.BoardService;
import com.von.api.common.component.MessengerVO;
import com.von.api.common.component.PageRequestVO;

import lombok.RequiredArgsConstructor;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found") })
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @PostMapping(path = "")
    public ResponseEntity<MessengerVO> save(PageRequestVO vo) throws SQLException {
        service.save(null);
        return ResponseEntity.ok(new MessengerVO());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MessengerVO> deleteById(@PathVariable long id) {
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVO());
    }

    @GetMapping(path = "")
    public ResponseEntity<MessengerVO> findAll(PageRequestVO vo) throws SQLException {
        service.findAll();
        return ResponseEntity.ok(new MessengerVO());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MessengerVO> findById(@PathVariable Long id) {
        service.findById(0L);
        return ResponseEntity.ok(new MessengerVO());
    }

    @GetMapping(path = "/count")
    public ResponseEntity<MessengerVO> count() {
        service.count();
        return ResponseEntity.ok(new MessengerVO());
    }

    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<MessengerVO> existById(@PathVariable long id) {
        service.existById(0L);
        return ResponseEntity.ok(new MessengerVO());
    }
}
