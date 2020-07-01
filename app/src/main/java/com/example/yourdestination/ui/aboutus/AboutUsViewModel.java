package com.example.yourdestination.ui.aboutus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutUsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutUsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is high efficiency android application. " +
                "This is used to find the details of the tourist place which the user wants to visit.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}