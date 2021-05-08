package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {


    /**
     * 快速入门
     */
    @Test
    public void test1() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        jedis.set("username", "zhangsan");

        //3. 关闭连接
        jedis.close();
    }


    /**
     * string 数据结构操作
     */
    @Test
    public void test2() {
        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        //存储
        jedis.set("username", "zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode", 20, "hehe");//将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对

        //3. 关闭连接
        jedis.close();
    }

    /**
     * hash 数据结构操作
     */
    @Test
    public void test3(){
        //获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值“localhost”，6379端口
        //2.操作
        //存储hash
        jedis.hset("username","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");
        //获取hash
        String name = jedis.hget("user","name");
        System.out.println(name);
        //获取hash的所有map中的数据
        Map<String,String> user = jedis.hgetAll("user");
        //keyset
        Set<String> keySet = user.keySet();
        for (String key :keySet
             ) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":"+value);
        }
        //3.关闭连接
        jedis.close();
    }
}