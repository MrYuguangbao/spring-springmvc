package com.springtest.bean.autowire.config;

import com.springtest.bean.autowire.config.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.autowire
 * @Author: admin
 * @CreateTime: 2020-06-09 16:15
 * @Description: ${Description}
 */
@Component
public class SgtPeppers implements CompactDisc {


    @Override
    public void play() {
        System.out.println("------SgtPeppers--------");
    }
}
