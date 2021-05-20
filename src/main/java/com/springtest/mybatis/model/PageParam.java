package com.springtest.mybatis.model;

import lombok.Data;

/**
 * @author admin
 * @desc
 * @date 2019/7/24 8:21
 */
@Data
public class PageParam {
    private int size;
    private int offset;

    public PageParam() {
        size = 3;
        offset = 0;
    }
}
