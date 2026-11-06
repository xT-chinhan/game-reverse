package com.mcto.sspsdk.internal;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class r4 {
    public final String a;
    public final Context b;
    public final NotificationManagerCompat c;
    public final HashMap d = new HashMap();
    public int e = 9527;

    public r4(Context context, String str) {
        this.b = context;
        this.a = str;
        this.c = NotificationManagerCompat.from(context);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("download_channel", "游戏或应用下载状态", 4);
            notificationChannel.setDescription("显示游戏或应用下载进度和状态的消息");
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
    }
}
