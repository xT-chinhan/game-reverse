package com.byazt.qd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.zi.l;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1607, 1608})
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (qg.n().n(hashCode())) {
            qg.n().n(context, intent);
        } else {
            l.s(new Runnable() { // from class: com.byazt.qd.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    qg.n().n(context, intent);
                }
            });
        }
    }
}
