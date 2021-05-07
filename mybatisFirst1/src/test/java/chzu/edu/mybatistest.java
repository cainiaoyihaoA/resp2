package chzu.edu;

import chzu.dao.Iuserdao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 黑马程序员
 * mybatis的入门案例
 */
public class mybatistest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory =builder.build(in);
        //3.使用工厂生产SqlSession创建dao接口的代理对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建dao接口的代理对象
        Iuserdao mapper = sqlSession.getMapper(Iuserdao.class);
        //5.使用代理对象执行方法
        List<user> findall = mapper.findall();
        for (user use:findall
             ) {
            System.out.println(use);
        }
        //6.释放资源
        sqlSession.close();
        in.close();



    }
}
