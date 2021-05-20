package com.springtest.mybatis.provider;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author admin
 * @desc
 * @date 2019/7/24 7:31
 */
public class MyDatabaseIdProvider implements DatabaseIdProvider {
    @Override
    public void setProperties(Properties p) {
        System.out.println("读取配置文件：" + p);
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        String name = connection.getMetaData().getDatabaseProductName();
        System.out.println("【当前使用的数据库是】:" + name);
        if ("MySQL".equals(name)) {
            return "mysql";
        }
        return null;
    }
}
