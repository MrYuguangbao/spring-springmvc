package com.springtest.mybatis.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author admin
 * @desc
 * @date 2019/7/24 7:01
 */
public class DBCPDatasourceFactory implements DataSourceFactory {
    private BasicDataSource basicDataSource = new BasicDataSource();
    private Properties props = null;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return dataSource;
    }
}
