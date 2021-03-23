package com.kunsubin.room_database_example;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.kunsubin.room_database_example.data.entity.User;
import com.kunsubin.room_database_example.repository.UserRepository;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
   // private final ExecutorService mExecutorService= Executors.newSingleThreadExecutor();
    private UserRepository mUserRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserRepository=new UserRepository();
        testDatabase();
    }
    
    private void testDatabase(){
        User user=new User();
        user.setFirstName("dsffdsdsf");
        user.setLastName("dsfsd");
        mUserRepository.insert(user)
                  .doOnSubscribe(onSubscribe->{
                      Log.d(TAG,"doOnSubscribe insert");
                  })
                  .subscribe(success->{
                      Log.d(TAG,"success insert "+success);
                  }, error->{
                      Log.d(TAG,"Error insert "+error.getMessage());
                  });
    
        mUserRepository.getAllUser()
                  .doOnSubscribe(onSubscribe->{
                      Log.d(TAG,"doOnSubscribe getAllUser");
                  })
                  .subscribe(success->{
                      Log.d(TAG,"success getAllUser "+success.toString());
                  }, error->{
                      Log.d(TAG,"Error getAllUser "+error.getMessage());
                  });
    }
}