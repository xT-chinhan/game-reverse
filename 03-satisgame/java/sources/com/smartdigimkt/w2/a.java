package com.smartdigimkt.w2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static volatile a b;
    public final Context a;

    public a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            try {
                LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        try {
            try {
                LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        }
    }

    public final void a(Intent intent) {
        try {
            try {
                LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        }
    }
}
