package com.example.myapplication_mysqldatashow.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("Done By: Akram Jaber\n " +
//                "         Abd Alkaleg\n" +
//                "         Fathl Twaff\n" +
//                "         Mojahed Silah\n" +
//                "         Sadeg Gahowan");
    }

    public LiveData<String> getText() {
        return mText;
    }
}