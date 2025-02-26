package com.example.myapplication_mysqldatashow.Models;

public class ClsEmpleyy {
    
    
  
        public int Id;
    
    public String NameAuthor;
    
    public String User_name;
        
        public String Date;
        public String PhoneUser;
        public String Details;
        
        public String Passowrds;
        
        public String Type;
   
 
    public ClsEmpleyy(String nameAuthor, String user_name, String date, String phoneUser, String details, String passowrds, String type) {
        NameAuthor = nameAuthor;
        User_name = user_name;
        Date = date;
        PhoneUser = phoneUser;
        Details = details;
        Passowrds = passowrds;
        Type = type;
        
    }
    public  ClsEmpleyy()
    {
    
    }
    public int getId() {
        return Id;
    }
    
    public void setId(int id) {
        Id = id;
    }
    
    public String getNameAuthor() {
        return NameAuthor;
    }
    
    public void setNameAuthor(String nameAuthor) {
        NameAuthor = nameAuthor;
    }
    
    public String getUser_name() {
        return User_name;
    }
    
    public void setUser_name(String user_name) {
        User_name = user_name;
    }
    
    public String getDate() {
        return Date;
    }
    
    public void setDate(String date) {
        Date = date;
    }
    
    public String getPhoneUser() {
        return PhoneUser;
    }
    
    public void setPhoneUser(String phoneUser) {
        PhoneUser = phoneUser;
    }
    
    public String getDetails() {
        return Details;
    }
    
    public void setDetails(String details) {
        Details = details;
    }
    
    public String getPassowrds() {
        return Passowrds;
    }
    
    public void setPassowrds(String passowrds) {
        Passowrds = passowrds;
    }
    
    public String getType() {
        return Type;
    }
    
    public void setType(String type) {
        Type = type;
    }
    
}
