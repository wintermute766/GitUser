package ru.sberbank.learning.gituser;

/**
 * Created by user10 on 23.05.2017.
 */

public class User {

    private String mLogin;
    private String mName;
    private int mId;
    private String mLocation;
    private String mType;

    public User(String Login, String Name, int Id, String Location, String Type) {
        this.mLogin = Login;
        this.mName = Name;
        this.mId = Id;
        this.mLocation = Location;
        this.mType = Type;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getType() {
        return mType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
