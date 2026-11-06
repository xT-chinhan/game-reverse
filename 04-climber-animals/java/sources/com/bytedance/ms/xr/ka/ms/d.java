package com.bytedance.ms.xr.ka.ms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes2.dex */
class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f574ms;

    d(Context context) {
        try {
            ms(context);
        } catch (Throwable unused) {
        }
    }

    private void ms(Context context) {
        context.registerReceiver(new ms(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int ms() {
        return this.f574ms;
    }

    private class ms extends BroadcastReceiver {
        private ms() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    d.this.f574ms = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
