package com.example.nait_slimene_amine_tp2.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nait_slimene_amine_tp2.model.User;

public class LoginController {
    private static final String PREF_NAME = "UserPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static LoginController instance;
    private String username;
    private String password;

    private static LoginController loginController;
    private User user;

    private LoginController() {
        // Private constructor for Singleton pattern
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    public void createUser(String userName, String password, Context context) {
        user = new User(userName, password);


        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    public static void recapUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(KEY_USERNAME, "");
        String password = sharedPreferences.getString(KEY_PASSWORD, "");

        if (!userName.isEmpty() && !password.isEmpty()) {
            instance.user = new User(userName, password);
        }
    }

    public User getUser() {
        return user;
    }
    public String getUsername(){
        return user.getUsername();
    }
    public String getPassword(){
        return user.getPswrd();
    }

}