package com.example.markel.itstepandroidproject.Misc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(isNetworkAvailable(context)){
            context.sendBroadcast(new Intent("NETWORK_ENABLE"));
        }
        else{
            context.sendBroadcast(new Intent("NETWORK_DISABLE"));
        }
    }

    boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
