package com.example.demo.DataAcess;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.el.ELException;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AcessDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=FLIGHTS;encrypt=false";
    private static final String USER = "hau_admin";
    private static final String PASSWORD = "Thanhhau1203@";
    private static HikariDataSource dataSource;

    private static DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        config.setMaximumPoolSize(10);
        return dataSource = new HikariDataSource(config);
    }

    private <T> List<T> getData(int _columnNumber, Class<T> clss) throws Exception {
        List<T> data = new ArrayList<>();
        try (Connection cn = getDataSource().getConnection()) {
            String SQL = "SELECT * FROM " + clss.getClass().getSimpleName();
            try (
                    PreparedStatement stmt = cn.prepareStatement(SQL);
                    ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    T obj = clss.getDeclaredConstructor().newInstance();
                    // String setData = "set";
                    try {
                        for (Field f : clss.getDeclaredFields()) {
                            Method setter = clss.getMethod("set" + f.getName(), f.getType());
                            setter.invoke(obj, res.getObject(f.getName()));
                        }
                    } catch (Exception error) {
                        throw new Exception("Error don't have column");
                    }
                }
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // private String firstUpper(String Name) {
    // if (Name == null)
    // return Name;
    // return Name.substring(0, 1).toUpperCase() + Name.substring(1);
    // // cut 0-1 and graft at 1->n
    // }

    // ghi dữ liệu đã bị chỉnh sửa
    // private boolean write_Modified_Data_To_DB(String _tableName,List<String>
    // data){
    // try(Connection cnt = getDataSource().getConnection()){
    // String SQL = "UPDATE " + _tableName +" SET ";
    // }
    // return true;
    // }

    private static void closeDataSource() { // đóng cuối Main
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
