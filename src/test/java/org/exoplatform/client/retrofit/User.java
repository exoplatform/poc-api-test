package org.exoplatform.client.retrofit;

/**
 * Created by rosso on 5/22/15.
 */
public enum User{
    john("john","gtn"),mary("mary","gtn");

    private final String userName;
    private final String password;

     User(String userName, String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
