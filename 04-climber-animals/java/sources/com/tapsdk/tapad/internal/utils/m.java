package com.tapsdk.tapad.internal.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    static class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            m.a(this.a);
        }
    }

    public static void a(Activity activity) {
        if (activity == null || b((Context) activity)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33 && ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.POST_NOTIFICATIONS")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 100);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", com.tapsdk.tapad.internal.ui.views.a.k);
            intent.putExtra("app_package", activity.getPackageName());
            intent.putExtra("app_uid", activity.getApplicationInfo().uid);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Activity activity, List<String> list) {
        ActivityCompat.requestPermissions(activity, (String[]) list.toArray(new String[0]), 10001);
    }

    public static boolean a(Context context) {
        String str;
        if (Build.VERSION.SDK_INT > 28) {
            if (a(context, "android.permission.READ_PRECISE_PHONE_STATE")) {
                return true;
            }
            str = "Don't have permission android.permission.READ_PRECISE_PHONE_STATE,getDeviceID failed";
        } else {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return true;
            }
            str = "Don't have permission android.permission.READ_PHONE_STATE,getDeviceID failed";
        }
        TapADLogger.d(str);
        return false;
    }

    public static boolean a(Context context, String str) {
        return context != null && context.checkSelfPermission(str) == 0;
    }

    public static void b(Activity activity) {
        if (activity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("通知提示");
        builder.setMessage("当前通知未开启，请在系统设置页面进行设置");
        builder.setCancelable(true);
        builder.setPositiveButton("去设置", new a(activity));
        builder.setCancelable(false);
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        builder.create().show();
    }

    public static boolean b(Context context) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return ActivityCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0;
        }
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }
}
