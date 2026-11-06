package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.embedapplog.b;
import com.bytedance.embedapplog.oh;

/* JADX INFO: loaded from: classes2.dex */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            b.ms(stringArrayExtra);
        } else {
            oh.xr((Throwable) null);
        }
    }
}
