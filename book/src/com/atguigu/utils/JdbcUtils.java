package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author sunchaowei
 * @create 2026/3/23-14:31
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {

        try {
            Properties properties = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /* *
     * 获取数据库连接池中的连接
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() {

        Connection connection = null;

        try {
            //从dataSource实例获取连接对象
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }

     /* *
     * 关闭连接，放回数据库连接池
     * @param connection 连接对象
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
