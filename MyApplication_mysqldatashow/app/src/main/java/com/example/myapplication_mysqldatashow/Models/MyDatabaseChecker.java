package com.example.myapplication_mysqldatashow.Models;


import com.example.myapplication_mysqldatashow.ui.home.HomeFragment;

 class MyDatabaseChecker extends HomeFragment implements Runnable {
    
        public void run() {
            while (true) {
    
                ClsEmplayyContros cv = new ClsEmplayyContros(getActivity());
            //    cv.Get_All_Data("employss", listView, getActivity());
                // تنفيذ عملية التحقق من قاعدة البيانات السرفرية هنا
                try {
                    Thread.sleep(5000); // توقف الخيط لمدة 5 ثواني
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        
}
