package com.annotation.profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.profile
 * @author:admin
 * @createTime 9月 20 2021 12:12:35
 */
@Profile("test")
@Configuration
@PropertySource("classpath:db.properties")
public class ProfileConfig implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String driver;

    private StringValueResolver resolver;

    @Profile("test")
    @Bean("dataSourceTest")
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(user);
        ds.setPassword("");
        ds.setDriverClass(driver);
        ds.setJdbcUrl("");
        return ds;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(user);
        ds.setPassword("");
        ds.setDriverClass(driver);
        ds.setJdbcUrl("");
        return ds;
    }

    @Profile("prod")
    @Bean("dataSourceProd")
    public DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(user);
        ds.setPassword("");
        ds.setDriverClass(driver);
        ds.setJdbcUrl("");
        return ds;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.resolver = stringValueResolver;
        this.driver = resolver.resolveStringValue("${db.driverClass}");
    }
}
