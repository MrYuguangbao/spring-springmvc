package com.annotation.autowire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 16:42:15
 */
@Repository
@Primary
public class SpringDao {
    private int label = 1;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "SpringDao{" +
                "label=" + label +
                '}';
    }
}
