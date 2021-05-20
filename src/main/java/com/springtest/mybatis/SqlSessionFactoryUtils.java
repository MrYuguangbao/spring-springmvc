package com.springtest.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 21:09
 */
public class SqlSessionFactoryUtils {

    private static SqlSessionFactory result = null;

    private SqlSessionFactoryUtils() {
    }

    public static SqlSessionFactory getResult() {
        if (result == null) {
            synchronized (SqlSessionFactoryUtils.class) {
                InputStream inputStream = null;
                try {
                    inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("META-INF/mybatis-config.xml");
                    if (result == null) {
                        result = new SqlSessionFactoryBuilder().build(inputStream);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    public static SqlSession getInstance() {
        if (result == null) {
            result = getResult();
        }
        return result.openSession();
    }

}
