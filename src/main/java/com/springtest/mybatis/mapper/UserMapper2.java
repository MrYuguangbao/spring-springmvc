package com.springtest.mybatis.mapper;

import com.springtest.mybatis.model.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper2 {
    @Select("select id,name,identify_id as identifyId from people where name=#{name}")
    public List<User> queryUserByName(String name);

}
