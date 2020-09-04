package com.voyager.test;

import com.voyager.dao.AnchorDao;
import com.voyager.dao.DerrickDao;
import com.voyager.dao.StressDao;
import com.voyager.dao.login.UserDao;
import com.voyager.dao.sync.BasketDao;
import com.voyager.domain.QueryAnchor;
import com.voyager.domain.QueryDerrick;
import com.voyager.domain.QueryStress;
import com.voyager.domain.login.User;
import com.voyager.domain.sync.QueryBasket;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
//        AnchorDao dao = sqlSession.getMapper(AnchorDao.class);
//        QueryAnchor r = dao.findRecentData();

//        DerrickDao dao = sqlSession.getMapper(DerrickDao.class);
//        QueryDerrick r = dao.findRecentData();

//        StressDao mapper = sqlSession.getMapper(StressDao.class);
//        QueryStress r = mapper.findRecentData();

        BasketDao mapper = sqlSession.getMapper(BasketDao.class);
        QueryBasket r = mapper.findRecentData();

        System.out.println(r.toString());

        sqlSession.close();
        inputStream.close();
    }

    @Test
    /**
     * 测试findALL
     */
    public void run2() throws IOException {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        AnchorDao dao = sqlSession.getMapper(AnchorDao.class);
        List<QueryAnchor> r = dao.findAllData();
        for(QueryAnchor data : r ){
            System.out.println(data);
        }
        sqlSession.close();
        inputStream.close();
    }
    @Test
    /**
     * 测试提交数据
     */
    public void run3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        Date date = new Date();
        QueryAnchor data = new QueryAnchor((float) 100.1, (float) 100.2, (float) 100.3, (float) 100.4, (float) 100.3, (float) 100.4, date);
        AnchorDao dao = sqlSession.getMapper(AnchorDao.class);
        dao.saveOneRecord(data);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void run4() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User admin = userDao.findUser("admin");
        System.out.println(admin);
    }

    /**
     * 插入数据
     * @throws IOException
     */
    @Test
    public void run5() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User("ordinary", "123456", 2 );
        int row = userDao.addUser(user);
        sqlSession.commit();
        System.out.println(row);

    }

    @Test
    public void run6() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list =userDao.getUsers();
        for(User user: list){
            System.out.println(user);
        }
    }


}
