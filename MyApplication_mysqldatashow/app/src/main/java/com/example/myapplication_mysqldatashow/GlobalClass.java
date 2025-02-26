package com.example.myapplication_mysqldatashow;

import android.app.Application;

public class GlobalClass  extends Application {

   private String  name_1;
   

 private    String  name_2;


private     String  name_3;

    public String getName_1() {
        return name_1;
    }

    public void setName_1(String name_1) {
        this.name_1 = name_1;
    }

    public String getName_2() {
        return name_2;
    }

    public void setName_2(String name_2) {
        this.name_2 = name_2;
    }

    public String getName_3() {
        return name_3;
    }

    public void setName_3(String name_3) {
        this.name_3 = name_3;
    }
}
