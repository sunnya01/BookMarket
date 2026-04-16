package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author sunchaowei
 * @create 2026/3/23-14:39
 */
public class JdbcUtilsTest {

    @Test
    public void getConnection() {

        for (int i = 0; i < 3; i++) {

            Connection connection = JdbcUtils.getConnection();

            System.out.println(connection);

            JdbcUtils.close(connection);

        }

    }

    @Test
    public void close() {
    }
}