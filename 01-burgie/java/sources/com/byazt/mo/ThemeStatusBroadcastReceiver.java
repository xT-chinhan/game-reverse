package com.byazt.mo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2328, 2329})
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    public WeakReference<pr> pr;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<pr> weakReference = this.pr;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pr.get().b_(intExtra);
    }

    public void pr(pr prVar) {
        this.pr = new WeakReference<>(prVar);
    }
}
