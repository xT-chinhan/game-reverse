package com.byazt.bq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.wo.c;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 122, 1481})
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (hw.pr().pr(hashCode())) {
            hw.pr().pr(context, intent);
        } else {
            c.hn(new Runnable() { // from class: com.byazt.bq.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    hw.pr().pr(context, intent);
                }
            });
        }
    }
}
