package com.example.markel.itstepandroidproject.Misc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.example.markel.itstepandroidproject.View.AuthorizationActivity;
import com.example.markel.itstepandroidproject.View.StateActivity;

public class NetworkStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intentTransition;

        if(!isNetworkAvailable(context)){
            intentTransition = new Intent(context, StateActivity.class);
            intentTransition.putExtra("message", "Нет интернет соединения");
        }
        else{
            intentTransition = new Intent(context, AuthorizationActivity.class);
        }

        context.startActivity(intentTransition);
    }

    boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
