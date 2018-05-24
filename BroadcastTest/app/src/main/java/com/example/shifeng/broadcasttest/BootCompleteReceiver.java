package com.example.shifeng.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    static final String action_boot = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent i = new Intent(context, MainActivity.class);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context.startForegroundService(i);
//        } else {
//            context.startService(i);
//        }
//
//        Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show();
        if (intent.getAction().equals(action_boot)) {
            Intent mBootIntent = new Intent(context, MainActivity.class);
            // 下面这句话必须加上才能开机自动运行app的界面
            mBootIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mBootIntent);
        }
    }
}
