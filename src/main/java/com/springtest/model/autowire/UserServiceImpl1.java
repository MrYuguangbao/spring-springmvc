package com.springtest.model.autowire;

import com.springtest.model.CusRole;
import com.springtest.model.annotation.pojo.Role;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author admin
 * @date 2020/1/6 19:37
 */
@Component(value = "service1")
@Primary
public class UserServiceImpl1 implements UserService {

    @Autowired
    private BasicDataSource dataSource;

    @Autowired
    private CusRole cusRole;

    @Autowired
    @Qualifier("cusRole1")
    private CusRole cusRoleBackup;

    @Autowired
    @Qualifier("cusRole2")
    private CusRole cusRoleBackup2;

    @Override
    public void printUserInfo(Role role) {
        System.out.println("userserviceimpl1:");
        System.out.println("cusRole:" + cusRole.toString());
        System.out.println("cusRoleBackup:" + cusRoleBackup.toString());
        System.out.println("cusRoleBackup2:" + cusRoleBackup2.toString());
    }

    @Override
    public Role getRole(long id) {
        Role role = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement("select id,img_url,name,identify_id from people where id = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setImg_url(rs.getString("img_url"));
                role.setIdentify_id(rs.getString("identify_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return role;
    }
}
