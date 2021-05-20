package com.springtest.transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Transactional
public class JavaConfig implements TransactionManagementConfigurer {
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return null;
    }
}
