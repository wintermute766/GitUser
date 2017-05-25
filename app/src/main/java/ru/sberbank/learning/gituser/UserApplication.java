package ru.sberbank.learning.gituser;

import android.app.Application;

/**
 * Created by eugene on 25.05.17.
 */

public class UserApplication extends Application implements UserStorageProvider {

    private UserStorage mUserStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        mUserStorage = new UserStorage();
    }

    @Override
    public UserStorage getUserStorage() {
        return mUserStorage;
    }
}
