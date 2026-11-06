package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f1348ms;

    public interface ms {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            sl.ms("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                sl.ms("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    sl.ms("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    sl.ms("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    sl.ms("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            sl.d("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
