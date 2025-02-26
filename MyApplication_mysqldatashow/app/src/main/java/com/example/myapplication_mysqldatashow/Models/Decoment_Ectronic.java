package com.example.myapplication_mysqldatashow.Models;

import com.example.myapplication_mysqldatashow.MainActivity4_drop;
import com.example.myapplication_mysqldatashow.MainActivity_mysqlserver;

import java.util.List;

public interface Decoment_Ectronic<Table> {
    public static final String SEND_DATA_URL = MainActivity4_drop.uri_P_2+"insert_decoment.php";
    public  static final Class<MainActivity_mysqlserver> context= MainActivity_mysqlserver.class;
    List<Table> list();
    Table Find(int id);
    
    
    void add(Table t);
    void update(Table t);
    void delete(String key);
    
    
}
