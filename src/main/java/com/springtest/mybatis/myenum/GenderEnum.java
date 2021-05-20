package com.springtest.mybatis.myenum;

import lombok.Data;

public enum GenderEnum {

    ELE1(0, "ELE1"),
    FEMALE(1, "女"),
    MALE(2, "男"),
    ELE2(3, "ELE2"),
    ELE3(4, "ELE3");

    private int id;
    private String name;

    GenderEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGenderById(int id) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.id == id) {
                return genderEnum;
            }
        }
        return null;
    }

}
