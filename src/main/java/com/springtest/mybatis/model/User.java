package com.springtest.mybatis.model;

import com.springtest.mybatis.myenum.GenderEnum;
import com.springtest.mybatis.myenum.IdentifyEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 16:07
 */
@Data
@Component
public class User {
    private int id;
    private String name;
    private String identifyId;
    private double weight;

    @Override
    public String toString() {
        return "[id=" + id + ",name=" + name + ",identifyid=" + identifyId + ",weight=" + weight + "]";
    }
}
