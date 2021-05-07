package chzu.dao;

import chzu.edu.user;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface Iuserdao {
    /**
查询所有操作
     */
    List<user> findall();
}
