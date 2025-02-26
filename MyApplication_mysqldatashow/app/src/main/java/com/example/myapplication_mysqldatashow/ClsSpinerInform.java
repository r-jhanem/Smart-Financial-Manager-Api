package com.example.myapplication_mysqldatashow;

public class ClsSpinerInform {
    
   public int Id;
    int IdEmp;
    String Name;
    String NameUser;
    
    public ClsSpinerInform(int id, int idEmp,
                           String name, String nameUser) {
        Id = id;
        IdEmp = idEmp;
        Name = name;
        
        NameUser = nameUser;
    }
    
    public ClsSpinerInform(int id,
                           String name) {
        Id = id;
        Name = name;
        
    }
}
