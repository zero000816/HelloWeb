package com.demo.dao;

import java.util.List;

public interface Role_AccessDao {
    List<Integer> findAllAidByRid(int rid);
}
