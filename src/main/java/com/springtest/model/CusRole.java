package com.springtest.model;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author admin
 * @date 2020/1/6 15:44
 */
public class CusRole {

    private long id;
    private String role;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public String getNote() {
        return note;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CusRole() {
    }

    public CusRole(String role, String note) {
        this.role = role;
        this.note = note;
    }

    @Override
    public String toString() {
        return "[id=" + id + ",role=" + role + ",note=" + note + "]";
    }
}
