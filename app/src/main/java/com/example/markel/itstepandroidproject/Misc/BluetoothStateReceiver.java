package com.example.markel.itstepandroidproject.Misc;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BluetoothStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isBluetoothAvailable()){
            context.sendBroadcast(new Intent("BLUETOOTH_ENABLE"));
        }
        else{
            context.sendBroadcast(new Intent("BLUETOOTH_DISABLE"));
        }
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
