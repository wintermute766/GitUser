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

    private User mCachedResult;

    public UserLoader(Context context) {
        super(context);
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
            JSONObject json = reader.readJsonFromUrl("https://api.github.com/users/twbs");
            User user = reader.getUser(json);
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
