package com.example.myapplication_mysqldatashow;

public class List_All_Users {
    public int idname;

public static int xx;
    public String User_name;

    public String RegDate;
    public String PhoneUser;
    public String Details;

    public String Avatar_img;

    public String Sol;
    public String sum_sol;
    public String UserKey2;
    public String  doof;


    public String Count_Name;
    public String Max_Sol;
    public String type;
    public String state;
    public int idname_2;
    public List_All_Users(int idname_2)
    {

        this.idname_2 = idname_2;
    }

    public List_All_Users(int idname,String user_name, String date, String sol, String type,String stye,String UserKey2) {
        User_name = user_name;
        this.  RegDate = date;
        this. Sol=sol;
        this. state=stye;
        this.  type = type;
this.UserKey2=UserKey2;

        this.idname = idname;

    }
    
    
    public List_All_Users(int idname,String user_name, String date, String sol, String type,String stye,String UserKey2,String doof) {
        User_name = user_name;
        this.  RegDate = date;
        this. Sol=sol;
        this. state=stye;
        this.  type = type;
        this.UserKey2=UserKey2;
        this.idname = idname;
        this.doof = doof;
    
    
    }
    /*

    public List_All_Users(int idname,String user_name) {
        User_name = user_name;
        this.idname = idname;
        int g=xx++;
    }
    public List_All_Users(String user_name, String PhoneUser, String max_Sol) {
        User_name = user_name;
        this.  PhoneUser = PhoneUser;
        this. Max_Sol=max_Sol;
        this.idname = idname;

        int g=xx++;
    }



    public List_All_Users(int idname,String user_name, String PhoneUser, String max_Sol) {
        User_name = user_name;
      this.  PhoneUser = PhoneUser;
       this. Max_Sol=max_Sol;
        this.idname = idname;

    }

    public String      Type_opation;

    public List_All_Users(int idname, String user_name, String regDate, String phoneUser, String details, String sol, String sum_sol, String userKey2, String type_opation)
    {
        this.idname = idname;
        User_name = user_name;
        RegDate = regDate;
        PhoneUser = phoneUser;
        Details = details;
        Sol = sol;
        this.sum_sol = sum_sol;
        UserKey2 = userKey2;
        Type_opation = type_opation;
    }
    */
}

