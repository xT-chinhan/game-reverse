package com.byazt.cl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.ec.w;
import com.byazt.gox.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1072, 1472})
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            x.pr(stringArrayExtra);
        } else {
            w.hw((Throwable) null);
        }
    }
}
