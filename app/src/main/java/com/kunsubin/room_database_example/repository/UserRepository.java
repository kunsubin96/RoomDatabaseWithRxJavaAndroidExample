package com.kunsubin.room_database_example.repository;


import com.kunsubin.room_database_example.data.AppDatabase;
import com.kunsubin.room_database_example.data.dao.UserDao;
import com.kunsubin.room_database_example.data.entity.User;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class UserRepository {
    private final UserDao mUserDao;
    public UserRepository(){
        AppDatabase appDatabase=AppDatabase.getInstance();
        mUserDao=appDatabase.userDao();
    }
    public Single<List<User>> getAllUser(){
        return mUserDao.getAll()
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread());
    }
    public Single<Long> insert(User user){
        return mUserDao.insert(user)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread());
        
    }
    public Single<Integer> delete(User user){
        return  mUserDao.delete(user)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread());
    }
}
