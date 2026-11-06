package com.smartdigimkt.m;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.smartdigimkt.dlopt.common.NotificationBroadcastReceiver;
import com.smartdigimkt.k.r;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static volatile j e;
    public NotificationManager a;
    public final HashMap b;
    public final Context c;
    public int d;

    public j(Context context) {
        a aVar = new a();
        this.c = context;
        this.a = context == null ? null : (NotificationManager) context.getSystemService("notification");
        this.b = new HashMap();
        try {
            IntentFilter intentFilter = new IntentFilter("sdm_action_notification_cannel");
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(aVar, intentFilter, 4);
            } else {
                context.registerReceiver(aVar, intentFilter);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static k a(j jVar, r rVar) {
        jVar.getClass();
        String str = rVar.o;
        k kVar = (k) jVar.b.get(str);
        if (kVar != null) {
            return kVar;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(jVar.c, str);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str, 3);
            notificationChannel.setSound(null, null);
            jVar.a.createNotificationChannel(notificationChannel);
        }
        jVar.d++;
        builder.setOngoing(true).setSound(null).setPriority(0).setOnlyAlertOnce(true).setAutoCancel(false);
        try {
            builder.setSmallIcon(jVar.c.getPackageManager().getApplicationInfo(jVar.c.getPackageName(), 128).icon);
        } catch (Throwable th) {
            th.printStackTrace();
            builder.setSmallIcon(com.smartdigimkt.r4.k.a(jVar.c, "core_icon_close", "drawable"));
        }
        builder.setContentTitle(rVar.c);
        Bitmap bitmap = rVar.d;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        k kVar2 = new k();
        kVar2.a = jVar.d;
        kVar2.b = builder;
        kVar2.c = -1;
        jVar.b.put(str, kVar2);
        return kVar2;
    }

    public static void a(j jVar, r rVar, NotificationCompat.Builder builder, k kVar) {
        jVar.getClass();
        com.smartdigimkt.k.c cVar = kVar.d;
        if (cVar == null || cVar != rVar.s) {
            kVar.d = rVar.s;
            Intent intent = new Intent("sdm_action_notification_click");
            intent.putExtra("sdm_broadcast_receiver_extra_unique_id", rVar.o);
            intent.putExtra("sdm_broadcast_receiver_extra_url", rVar.b);
            intent.putExtra("sdm_broadcast_receiver_extra_request_status", rVar.s.toString());
            intent.putExtra("sdm_broadcast_receiver_extra_notification_id", kVar.a);
            intent.setClass(jVar.c, NotificationBroadcastReceiver.class);
            int i = Build.VERSION.SDK_INT;
            PendingIntent broadcast = PendingIntent.getBroadcast(jVar.c, kVar.a, intent, i >= 31 ? 201326592 : 134217728);
            Intent intent2 = new Intent("sdm_action_notification_cannel");
            intent2.setPackage(jVar.c.getPackageName());
            intent2.putExtra("sdm_broadcast_receiver_extra_unique_id", rVar.o);
            intent2.putExtra("sdm_broadcast_receiver_extra_url", rVar.b);
            intent2.putExtra("sdm_broadcast_receiver_extra_request_status", rVar.s.toString());
            intent2.putExtra("sdm_broadcast_receiver_extra_notification_id", kVar.a);
            builder.setContentIntent(broadcast).setDeleteIntent(PendingIntent.getBroadcast(jVar.c, kVar.a, intent2, i < 31 ? 134217728 : 201326592));
        }
    }

    public static j a(Context context) {
        if (e == null) {
            synchronized (j.class) {
                if (e == null) {
                    e = new j(context);
                }
            }
        }
        return e;
    }

    public final synchronized void a(r rVar, long j, long j2, boolean z) {
        if (rVar != null) {
            if (!TextUtils.isEmpty(rVar.b)) {
                com.smartdigimkt.q3.f.a().a(new b(j, j2, rVar, this, z));
            }
        }
    }

    public final void a(r rVar) {
        if (rVar == null || TextUtils.isEmpty(rVar.b) || this.a == null) {
            return;
        }
        com.smartdigimkt.q3.f.a().a(new g(this, rVar));
    }
}
