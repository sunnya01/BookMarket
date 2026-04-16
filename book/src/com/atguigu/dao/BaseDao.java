package com.atguigu.dao;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sunchaowei
 * @create 2026/3/23-15:06
 */
public abstract class BaseDao {

    //使用DbUtils 操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /*
     * update() 方法用来执行: Insert Update Delete 语句
     * @return -1表示执行失败 其他表示收到影响的行数
     * */
    public int update(String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return -1;

    }

    /**
     * 查询并返回一个javaBean的sql语句
     *
     * @param type 返回对象的类的.Class对象
     * @param sql  执行的sql语句
     * @param args 执行的sql语句的参数
     * @param <T>  返回值类型的泛型
     * @return T 返回的T类型的javaBean对象
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return null;

    }

    /**
     * 查询并返回多个javaBean的sql语句
     *
     * @param type 返回对象的类的.Class对象
     * @param sql  执行的sql语句
     * @param args 执行的sql语句的参数
     * @param <T>  返回值类型的泛型
     * @return List<T>  返回的T类型的javaBean数组对象
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return null;

    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args 执行的sql语句的参数
     * @return Object 返回查询结果
     */
    public Object queryForSingleValue(String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}