package com.kunsubin.room_database_example.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.kunsubin.room_database_example.RootApplication;
import com.kunsubin.room_database_example.data.dao.UserDao;
import com.kunsubin.room_database_example.data.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    
    //import dao
    public abstract UserDao userDao();
    
    private static volatile AppDatabase INSTANCE;
    
    public static AppDatabase getInstance(){
        if(INSTANCE==null){
            synchronized (AppDatabase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(RootApplication.getContext(),
                              AppDatabase.class, "database_example").build();
                }
            }
        }
        return INSTANCE;
    }
    
}
