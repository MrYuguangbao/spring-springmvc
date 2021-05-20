package com.springtest.model.annotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/1/6 15:44
 */
@Component
public class Role {

    @Value("12")
    private long id;
    @Value("myrole")
    private String role;
    @Value("mynote")
    private String note;

    private String img_url;
    private String name;
    private String identify_id;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify_id() {
        return identify_id;
    }

    public void setIdentify_id(String identify_id) {
        this.identify_id = identify_id;
    }

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

    public Role() {
    }

    public Role(String role, String note) {
        this.role = role;
        this.note = note;
    }

    @Override
    public String toString() {
        return "[id=" + id + ",role=" + role + ",note=" + note + ",img_url=" + img_url + ",name=" + name + ",identify_id=" + identify_id + "]";
    }
}
