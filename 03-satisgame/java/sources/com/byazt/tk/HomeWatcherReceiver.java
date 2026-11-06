package com.byazt.tk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 2237})
public class HomeWatcherReceiver extends BroadcastReceiver {
    public n n;

    public interface n {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                if ("homekey".equals(stringExtra) || "recentapps".equals(stringExtra)) {
                    return;
                }
                "assist".equals(stringExtra);
            }
        } catch (Throwable unused) {
            k.qg("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
