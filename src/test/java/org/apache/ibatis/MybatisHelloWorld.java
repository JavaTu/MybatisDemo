package org.apache.ibatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisHelloWorld {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            InputStream stream = Resources.getResourceAsStream("resources/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> list = userMapper.queryList(new HashMap<String, Object>());
            System.out.println(list.get(0).getNickName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
