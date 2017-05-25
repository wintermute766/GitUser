package ru.sberbank.learning.gituser;

/**
 * Created by eugene on 25.05.17.
 */

public class UserStorage {

    private User mUser;

    public UserStorage() {
        mUser = new User("Login","Name",0,"Location","Type");
    }

    public User getUser() {
        return mUser;
    }

    public void updateUser(User user) {
        mUser = user;
    }

}
