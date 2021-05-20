package com.springtest.model;

import java.util.List;

/**
 * @author admin
 * @date 2020/1/6 16:19
 */
public class ComplexAssembly {

    private Long id;
    private List<String> list;
    private List<CusRole> roleList;

    public List<CusRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<CusRole> roleList) {
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
