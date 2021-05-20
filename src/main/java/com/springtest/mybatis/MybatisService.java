package com.springtest.mybatis;

import com.springtest.mybatis.mapper.UserMapper;
import com.springtest.mybatis.mapper.UserMapper2;
import com.springtest.mybatis.model.User;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 15:42
 */
public class MybatisService {

    public SqlSession getSqlSessionByXML() {
        SqlSession sqlSession = getSqlSessionFactoryByXML().openSession();
        return sqlSession;
    }

    public SqlSession getSqlSessionByCode() {
        SqlSession sqlSession = getSqlSessionFactoryByCode().openSession();
        return sqlSession;
    }

    public SqlSessionFactory getSqlSessionFactoryByCode() {
        SqlSessionFactory result = null;
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatistest?" +
                "useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("yuguangbao");
        dataSource.setDefaultAutoCommit(false);
        TransactionFactory transaction = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transaction, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.getTypeAliasRegistry().registerAlias("user", User.class);
        //configuration.addMapper(UserMapper.class);//通过xml方式实现映射器
        configuration.addMapper(UserMapper2.class);//通过注解实现映射器
        result = new SqlSessionFactoryBuilder().build(configuration);
        return result;
    }

    public SqlSessionFactory getSqlSessionFactoryByXML() {
        SqlSessionFactory result = null;
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("META-INF/mybatis-config.xml");
            result = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
