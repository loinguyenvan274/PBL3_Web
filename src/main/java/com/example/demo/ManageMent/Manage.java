package com.example.demo.ManageMent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.demo.DataAcess.AcessDB;

// List -> HashMap ->
// Cache , service 
public class Manage<T> extends HashMap<String, List<String>> {
    private int Column;
    private List<T> data;
    // private T obj;
    private AcessDB ACess = new AcessDB();

    Manage(int col) {
        this.Column = col;
        data = null;
    }

    Manage<T> GetData(List<T> dataIn, Class<T> clss) { // Read
        data = dataIn;
        Manage<T> exManage = new Manage<>(Column);
        List<String> dataOjb = new ArrayList<>();
        String key = null;
        for (T t : data) {
            int index = 0;
            try {
                for (Field f : clss.getDeclaredFields()) {
                    Method getter = clss.getMethod("get" + f.getName());
                    if (index == 0) {
                        key = getter.invoke(t).toString();
                    } else {
                        dataOjb.add(getter.invoke(t).toString().toString());
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.put(key, dataOjb);
        }
        return exManage;
    }

    List<T> Sort() {
        return this.data;
    }

    boolean Insert(String key, List<String> value) { // Create
        if (this.containsKey(key)) {
            return false;
        }
        this.put(key, value);
        return true;
    }

    boolean Delete(String key) {
        if (!this.containsKey(key))
            return false;
        this.remove(key);
        return true;
    }

    boolean Update(String key, List<String> newValue) { //
        if (!this.containsKey(key)) // Nếu key chưa tồn tại -> thêm mới
        {
            this.Insert(key, newValue);
            return true;
        }
        this.put(key, newValue);
        return true;
    }

}

/*
 * HashMap<String,List<String>> -> {id , String = {"dfdf" , " Fdfdf" , 'fdf'}}
 * Create , Read , Update ,Delete
 * 3 layer
 * Object
 * Service
 * Access databse
 */