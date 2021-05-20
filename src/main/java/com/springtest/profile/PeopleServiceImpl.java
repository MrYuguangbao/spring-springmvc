package com.springtest.profile;

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
 * @date 2019/7/27 17:13
 */
@Component("peopleServiceImpl")
@Profile("dev")
public class PeopleServiceImpl implements IPeople {

    @Autowired
    @Qualifier("devDataSource")
    private DataSource dataSource;

    @Override
    public People queryPeopleById(int id) {
        System.out.println("----------------- 调用 dbcp DataSource ----> " + dataSource.getClass());
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        People people = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select id,name,identify_id from people where id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                people = new People();
                people.setId(resultSet.getInt("id"));
                people.setName(resultSet.getString("name"));
                people.setIdentifyId(resultSet.getString("identify_id"));
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
        return people;
    }
}
