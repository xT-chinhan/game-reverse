package com.smartdigimkt.dlopt.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.smartdigimkt.j.u;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        intent.getStringExtra("sdm_broadcast_receiver_extra_url");
        String stringExtra = intent.getStringExtra("sdm_broadcast_receiver_extra_unique_id");
        String stringExtra2 = intent.getStringExtra("sdm_broadcast_receiver_extra_request_status");
        int intExtra = intent.getIntExtra("sdm_broadcast_receiver_extra_notification_id", -1);
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.getClass();
        if (action.equals("sdm_action_notification_cannel")) {
            u.a(context).a(stringExtra, stringExtra2);
        } else if (action.equals("sdm_action_notification_click")) {
            u.a(context).a(stringExtra, stringExtra2, intExtra, true);
        }
    }
}
