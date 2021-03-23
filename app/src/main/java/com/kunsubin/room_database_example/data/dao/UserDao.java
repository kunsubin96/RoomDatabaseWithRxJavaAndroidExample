package com.kunsubin.room_database_example.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.kunsubin.room_database_example.data.entity.User;
import io.reactivex.Single;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    Single<List<User>> getAll();
    
    @Query("SELECT * FROM user WHERE uid = (:id)")
    Single<User> findUserById(int id);
    
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    Single<List<User>> loadAllByIds(int[] userIds);
    
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
           "last_name LIKE :last LIMIT 1")
    Single<User> findByName(String first, String last);
    
    @Insert
    Single<Long> insert(User user);
    
    @Insert
    Single<List<Long>> insert(User[] user);
    
    @Update
    Single<Integer> update(User user);
    
    @Update
    Single<Integer> update(User[] user);
    
    @Delete
    Single<Integer> delete(User user);
}
