package com.springtest.mybatis;

import com.springtest.mybatis.mapper.UserMapper;
import com.springtest.mybatis.model.PageParam;
import com.springtest.mybatis.model.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 21:17
 */
public class MybatisTest1 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MybatisTest1.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.getInstance();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //传递列表、数组、集合参数
            /*List<Integer> idList = new ArrayList<>();
            Set<Integer> sets = new HashSet<>();
            for (int i = 6; i < 9; i++) {
                idList.add(i);
                sets.add(i);
            }
            userMapper.queryByList(1,idList);
            int[] array = {7,8,9};
            userMapper.queryByArray(array);
            userMapper.queryBySet(sets);*/


            //int update = userMapper.updateUser(3, "verskdkfk", null);

            //查询测试
            /*User queryParam = new User("许戊己","E1558026735001");
            queryParam.setId(3);
            queryParam.setWeight(90.00);
            PageParam pageParam = new PageParam();
            RowBounds rowBounds = new RowBounds(0,6);*/

            /*Map<String,Object> queryMap = new HashMap<>();
            queryMap.put("id",6);
            queryMap.put("nameParam","辛己3庚");
            User query1 = userMapper.queryUserByMap(queryMap);*/

            //sqlSession.clearCache();
            //int update = userMapper.updateUser(3);
            //int delete = userMapper.deleteUserById(4);
            //int insert = userMapper.insertUser(new User("generatedKeys新增测试1","33333333333"));
            //User query2 = userMapper.queryUserById(3);
            //System.out.println(query1 == query2);
            /*User user = userMapper.queryUser(3);
            System.out.println(user.getId()+","+user.getName()+","+user.getIdentifyId());*/

            //新增测试
            /*User insertUser = new User("generatedKeys新增测试","111111111");
            int insert = userMapper.insertUser(insertUser);
            System.out.println("新增结果:"+insert);*/

            //删除测试
            /*int delete = userMapper.deleteUserById(323114);
            System.out.println("删除结果："+delete);*/

            /*List<User> list = userMapper.queryUser2("许戊己");
            list.forEach((e)-> System.out.println(e.getId()+","+e.getName()+","+e.getIdentifyId()));*/

            User user = userMapper.queryUserBySqlBuilder("367856196408279219");
            System.out.println("user信息：" + user);


            /*User updateUser = new User("郑庚辛","294218198609064710");
            updateUser.setId(412);
            int update = userMapper.updateUser(updateUser);
            System.out.println("修改结果："+update);*/
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
