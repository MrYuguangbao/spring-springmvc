package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 12:46
 */
@Component("myUserserviceImpl")
@Profile("dev")
public class MyUserService implements IUser {

    @Autowired
    private DataSource dataSource;

    @Override
    public void printUserInfo(User user) {

    }

    @Override
    public void printUsrInfo1() {

    }

    @Override
    public User queryUserByBean(int id) {
        System.out.println("----------------- 调用 dbcp DataSource");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select id,name,identify_id from people where id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setIdentifyId(resultSet.getString("identify_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
