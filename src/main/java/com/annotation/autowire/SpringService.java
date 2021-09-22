package com.annotation.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 16:42:40
 */
@Service
public class SpringService {

    //@Qualifier("springDao")
    @Autowired(required = false)
    private SpringDao springDao2;

    @Resource(name = "javaDao2")
    private JavaDao javaDao;

    @Override
    public String toString() {
        return "SpringService{" +
                "springDao2=" + springDao2 +
                ", javaDao=" + javaDao +
                '}';
    }
}
