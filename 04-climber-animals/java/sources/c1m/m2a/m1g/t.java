package c1m.m2a.m1g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        if (Build.VERSION.SDK_INT >= 33) {
            b.a().b("BroadcastReceiverCompat target>= 33", new Object[0]);
            context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
        } else {
            b.a().b("BroadcastReceiverCompat target< 33", new Object[0]);
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
