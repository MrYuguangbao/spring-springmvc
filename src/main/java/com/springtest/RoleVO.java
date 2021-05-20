package com.springtest;

import lombok.Data;

/**
 * @author admin
 * @date 2020/1/7 10:14
 */
@Data
public class RoleVO {

    private Long id;
    private String name;
    private String note;

    @Override
    public String toString() {
        return "[id=" + id + ",name=" + name + ",note=" + note + "]";
    }
}
