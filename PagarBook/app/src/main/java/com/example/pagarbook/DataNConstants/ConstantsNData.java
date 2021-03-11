package com.example.pagarbook.DataNConstants;

import android.content.Context;
import android.content.SharedPreferences;

public class ConstantsNData {

    public static final String SERVER = "https://avdhutpcb.com/";
    public static final String END_HOST = "https://avdhutpcb.com/api/";
    public static final String AUTH_KEY = "8c8614d50a762f512d44c4ca668f4c1dbba1011a0643de895701baad9d88c64c";
    public static final String PRODUCT_PHOTO_PATH = SERVER + "/products/";
    public static final String INSTANTQUOTEPCB_PHOTO_PATH = SERVER + "/instantquotepcbs/";


    SharedPreferences sharedpreferences;
    private static final String MY_PREF = "AVDHUTPCBWorkPlace";
    private static final String USER_ID_KEY = "useridkey";
    private static final String LOGIN_STATUS_KEY = "LoginStatus";
    private static final String USER_NAME_KEY = "usernamekey";
    private static final String USER_EMAIL_KEY = "useremailkey";
    private static final String USER_PASS_KEY = "userpasskey";
    private static final String USER_MOBILE_KEY = "mobileKey";
    private static final String USER_ADDRESS_KEY = "address";
    private static final String USER_PROFILE_PATH_KEY = "profilepathkey";
    private static final String USER_FIREBASE_TOKEN = "firebaseToeknKey";
    private static final String USER_FIREBASE_UPDATE_STATUS_KEY = "firebaseUpdateStausKey";

    private static final String USER_NEW_STATUS = "newuserStatus";
    private static final String PRODUCT_REFRESH_STATUS = "productRefreshStatus";


    public String getProductRefreshStatus(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(PRODUCT_REFRESH_STATUS, "0");
    }

    public void setProductRefreshStatus(Context context, String prstatus) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(PRODUCT_REFRESH_STATUS, prstatus);
        editor.commit();
    }

    public String getNewUserStatus(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_NEW_STATUS, "0");
    }

    public void setNewUserStatus(Context context, String newuserState) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_NEW_STATUS, newuserState);
        editor.commit();
    }

    public String getLoginStatus(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(LOGIN_STATUS_KEY, "0");
    }

    public void setLoginStatus(Context context, String loginStatus) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LOGIN_STATUS_KEY, loginStatus);
        editor.commit();
    }

    public String getFireBaseTokenUpdateStatus(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_FIREBASE_UPDATE_STATUS_KEY, "0");
    }

    public void setFirebaseTokenUpdateStatus(Context context, String status) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_FIREBASE_UPDATE_STATUS_KEY, status);
        editor.commit();
    }

    public String getFireBaseToken(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_FIREBASE_TOKEN, "0");
    }

    public void setFireBaseToken(Context context, String token) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_FIREBASE_TOKEN, token);
        editor.commit();
    }


    public void setAddress(Context context, String pAddress) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_ADDRESS_KEY, pAddress);
        editor.commit();
    }

    public void setPassword(Context context, String ppass) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_PASS_KEY, ppass);
        editor.commit();
    }


    public String getUserID(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_ID_KEY, "0");
    }

    public String getUserName(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_NAME_KEY, "0");
    }

    public String getUserEmail(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_EMAIL_KEY, "0");
    }

    public String getUserMobile(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_MOBILE_KEY, "0");
    }



    public String getuserPass(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_PASS_KEY, "0");
    }

    public String getUserProfilePath(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_PROFILE_PATH_KEY, "0");
    }

    public String getUserAddress(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_ADDRESS_KEY, "0");
    }

    public void setUserName(Context context, String pname) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_NAME_KEY, pname);
        editor.commit();
    }


    public void setUserEmail(Context context, String pemail) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_EMAIL_KEY, pemail);
        editor.commit();
    }

    public void updateProfle(Context context, String pname, String pMobile, String ppass){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_NAME_KEY, pname);
        editor.putString(USER_MOBILE_KEY, pMobile);
        editor.putString(USER_PASS_KEY, ppass);
        editor.commit();
    }

    public void SaveProfile(Context context, String puserid, String pname, String pemail, String pmobile, String ppass) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_ID_KEY, puserid);
        editor.putString(USER_NAME_KEY, pname);
        editor.putString(USER_EMAIL_KEY, pemail);
        editor.putString(USER_MOBILE_KEY, pmobile);
        editor.putString(USER_PASS_KEY, ppass);
        editor.commit();
    }






}
