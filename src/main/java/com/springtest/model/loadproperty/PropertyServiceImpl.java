package com.springtest.model.loadproperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author admin
 * @date 2020/1/6 23:19
 */
@Component
public class PropertyServiceImpl {

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean(name = "propertyVO")
    @Conditional({DBConditional.class})
    public PropertyVO getProperties() {
        PropertyVO vo = new PropertyVO();
        vo.setParam1(username);
        vo.setParam2(password);
        return vo;
    }

}
