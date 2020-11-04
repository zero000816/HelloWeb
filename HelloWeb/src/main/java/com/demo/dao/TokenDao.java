package com.demo.dao;

public interface TokenDao {
    boolean addToken(String name,String token);
    String findByName(String name);
    boolean deleteToken(String name);
}
