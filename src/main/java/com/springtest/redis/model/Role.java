package com.springtest.redis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 * @date 2019/8/7 0:12
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -8319628099480903554L;
    private long id;
    private String roleName;
}
