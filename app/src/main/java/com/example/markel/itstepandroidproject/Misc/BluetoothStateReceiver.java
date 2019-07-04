package com.example.markel.itstepandroidproject.Misc;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.example.markel.itstepandroidproject.View.StateActivity;

public class BluetoothStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intentTransition = new Intent(context, StateActivity.class);

        if(isBluetoothAvailable()){
            intentTransition.putExtra("message", "Positive");
        }
        else{
            intentTransition.putExtra("message", "Negative");
        }

        context.startActivity(intentTransition);
    }

    private boolean isBluetoothAvailable() {

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            return false;
        } else {
            if (!mBluetoothAdapter.isEnabled()) return false;
            return true;
        }
    }
}
