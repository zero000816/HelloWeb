package com.demo.dao;
import com.demo.entity.Access;

public interface AccessDao {
    Boolean addAccess(Access access);

    Access findByAid(int aid);

}
