package ru.sberbank.learning.gituser;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by user10 on 23.05.2017.
 */

public class UserLoader extends AsyncTaskLoader<User> {

    private UserStorage mUserStorage;
    private User mCachedResult;
    private String api = "https://api.github.com/users/";

    public UserLoader(Context context, UserStorage userStorage) {
        super(context);
        mUserStorage = userStorage;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if ((mCachedResult == null) || takeContentChanged()) {
            forceLoad();
        }
    }

    @Override
    public void deliverResult(User data) {
        super.deliverResult(data);
        mCachedResult = data;
    }

    @Override
    public User loadInBackground() {
        try {
            JsonReader reader = new JsonReader();
            String url = new StringBuilder()
                    .append(api)
                    .append(mUserStorage.getUser().getLogin())
                    .toString();
            JSONObject json = reader.readJsonFromUrl(url);
            User user = reader.getUser(json);
            mUserStorage.updateUser(user);
            return user;

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
