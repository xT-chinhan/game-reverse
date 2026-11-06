package com.byazt.zk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2285, 2457})
public class MiniAppBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("pma_data");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                n.n().n(stringExtra);
            } catch (Exception unused) {
            }
        }
    }
}
