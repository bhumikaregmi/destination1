package com.example.yourdestination.ui.rateus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RateUsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RateUsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rate Us ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}