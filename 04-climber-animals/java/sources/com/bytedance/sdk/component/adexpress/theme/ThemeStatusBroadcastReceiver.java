package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<ms> f907ms;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<ms> weakReference = this.f907ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f907ms.get().b_(intExtra);
    }

    public void ms(ms msVar) {
        this.f907ms = new WeakReference<>(msVar);
    }
}
