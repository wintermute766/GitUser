package ru.sberbank.learning.gituser;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    private static final int USER_LOADER_ID = 1;

    private ProgressBar mProgressBar;
    private Button mButton;
    private EditText mUserEditText;

    private TextView mLogin;
    private TextView mName;
    private TextView mId;
    private TextView mLocation;
    private TextView mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_user);

        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mButton = (Button) findViewById(R.id.find_user_button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                getSupportLoaderManager().getLoader(USER_LOADER_ID).forceLoad();
            }
        });
        mUserEditText = (EditText) findViewById(R.id.search_query);
        mUserEditText.addTextChangedListener(new TextWatcherImpl());

        mLogin = (TextView) findViewById(R.id.login);
        mName = (TextView) findViewById(R.id.name);
        mId = (TextView) findViewById(R.id.id);
        mLocation = (TextView) findViewById(R.id.location);
        mType = (TextView) findViewById(R.id.type);

        getSupportLoaderManager().initLoader(USER_LOADER_ID, null, new UserLoaderCallbacks());
    }

    private class UserLoaderCallbacks implements LoaderManager.LoaderCallbacks<User> {

        @Override
        public Loader<User> onCreateLoader(int id, Bundle args) {
            return new UserLoader(UserActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<User> loader, User data) {
            mLogin.setText(data.getLogin());
            mName.setText(data.getName());
            mId.setText(String.valueOf(data.getId()));
            mLocation.setText(data.getLocation());
            mType.setText(data.getType());

            mProgressBar.setVisibility(View.GONE);
        }

        @Override
        public void onLoaderReset(Loader<User> loader) {
        }
    }

    private class TextWatcherImpl implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean buttonEnabled = true;
            if (TextUtils.isEmpty(mUserEditText.getText())) {
                buttonEnabled = false;
            }
            mButton.setEnabled(buttonEnabled);
        }
    }
}
