package com.kunsubin.room_database_example;

import android.app.Application;
import android.content.Context;

public class RootApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }
    
    public static Context getContext(){
        return mContext;
    }
}
