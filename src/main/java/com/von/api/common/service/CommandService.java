package com.von.api.common.service;

import java.sql.SQLException;

public interface CommandService<T> {
    T save(T t) throws SQLException;
    void deleteById(Long id);
    T modify(T t);
    
}