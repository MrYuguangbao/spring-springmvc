package com.springtest.mybatis;

import com.springtest.mybatis.mapper.UserMapper;
import com.springtest.mybatis.mapper.UserMapper2;
import com.springtest.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 17:25
 */
public class ExecuteService {

    public static void main(String[] args) {
        MybatisService service = new MybatisService();
        SqlSession sqlSession = service.getSqlSessionByXML();

        try {
            try {
                System.out.println("通过xml配置的sql");
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                /*User user = userMapper.queryUser(1);
                System.out.println(user.getId()+","+user.getName()+","+user.getIdentifyId());*/

                /*userMapper.deleteUserById(2);
                System.out.println("删除成功！");*/

            } catch (Exception e) {
                throw new Exception("加载usermapper.xml文件异常");
            } finally {
                System.out.println("通过注解配置的sql");
                //List<User> list = sqlSession.selectList("com.springtest.mybatis.mapper.UserMapper2.queryUserByName","辛己3庚");
                UserMapper2 mapper2 = sqlSession.getMapper(UserMapper2.class);
                List<User> list = mapper2.queryUserByName("辛己3庚");
                for (User user1 : list) {
                    System.out.println(user1.getId() + "," + user1.getName() + "," + user1.getIdentifyId());
                }
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }


    }

}
