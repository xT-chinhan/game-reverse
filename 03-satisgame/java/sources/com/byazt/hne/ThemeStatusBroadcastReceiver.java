package com.byazt.hne;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2524, 2525})
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    public WeakReference<n> n;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<n> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().b_(intExtra);
    }

    public void n(n nVar) {
        this.n = new WeakReference<>(nVar);
    }
}
