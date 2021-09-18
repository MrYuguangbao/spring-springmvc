package com.annotation.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.conditional
 * @author:admin
 * @createTime 9月 18 2021 22:59:48
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String os = environment.getProperty("os.name");
        if (os.contains("Windows")) {
            return true;
        }
        return false;
    }
}
