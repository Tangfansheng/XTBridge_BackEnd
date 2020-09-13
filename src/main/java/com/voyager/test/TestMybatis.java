package com.voyager.test;

import com.voyager.dao.AnchorDao;
import com.voyager.dao.DerrickDao;
import com.voyager.dao.user.UserDao;
import com.voyager.dao.sync.BasketDao;
import com.voyager.domain.QueryAnchor;
import com.voyager.domain.QueryDerrick;
import com.voyager.domain.user.User;
import com.voyager.domain.sync.QueryBasket;
import com.voyager.service.DerrickService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
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
        List<QueryAnchor> data = dao.findRecent10Data();
        System.out.println(data);
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
        int row = userDao.deleteUser("ordinary");
        sqlSession.commit();
        System.out.println(row);

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
        UserDao dao = sqlSession.getMapper(UserDao.class);
        int voyager = dao.editUser(new User("tangfs", "tangfs", 1));
        System.out.println(voyager);
        sqlSession.commit();
    }


}
