package com.springtest.mybatis.myenum;

public enum IdentifyEnum {

    E1558026735001("E1558026735001", 150),
    ELE2("1558026735002", 151),
    ELE3("1558026735003", 152),
    ELE4("1558026735004", 153),
    ELE5("1558026735005", 154);

    private String key;
    private int id;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    IdentifyEnum(String key, int id) {
        this.key = key;
        this.id = id;
    }

}
