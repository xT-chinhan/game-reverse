package com.byazt.ni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.fo.q;
import com.byazt.km.cp;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1085, 1597})
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            q.n(stringArrayExtra);
        } else {
            cp.qg((Throwable) null);
        }
    }
}
